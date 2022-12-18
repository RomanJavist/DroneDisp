package com.nemirovsky.dronedispatcher.controller;

import com.nemirovsky.dronedispatcher.model.*;
import com.nemirovsky.dronedispatcher.service.DroneService;
import com.nemirovsky.dronedispatcher.service.LoadService;
import com.nemirovsky.dronedispatcher.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DroneController {

    @Autowired
    private DroneService droneService;

    @Autowired
    private MedicationService medicationService;

    @Autowired
    private LoadService loadService;

    private final String helloString = "DroneDispatcher v1.0";

    private String errMsg = new String();

    @GetMapping("drones")
    public ModelAndView getAllDrones(@RequestParam(required = false, name = "available") boolean available) {

        ModelAndView mav = new ModelAndView("drones");

        List<Drone> drones = available ? droneService.findByState(DroneState.IDLE) :
                droneService.getAllDrones();

        mav.addObject("helloString", helloString);
        mav.getModelMap().addAttribute("drones", drones);
        mav.addObject("droneCount", droneService.getAllDrones().size());
        mav.addObject("droneAvailableCount", droneService.findByState(DroneState.IDLE).size());

        return mav;
    }

    @GetMapping("drone/{id}")
    public ModelAndView getDrone(@PathVariable String id,
                                 @RequestParam(required = false, name = "action") String action,
                                 @RequestParam(required = false, name = "code") String code,
                                 @ModelAttribute("drone") Drone newDrone) {

        Drone drone = droneService.getById(id);

        if (action != null) {

            switch (action) {
                case "save" -> {
                    droneService.save(newDrone);
                    drone = newDrone;
                }
                case "add" -> {
                    Integer weight = medicationService.getByCode(code).getWeight();
                    if (drone.getLoad() + weight > drone.getLoadMax()) {
                        errMsg = "Can't overload a drone!";
                        break;
                    }
                    drone.setLoad(drone.getLoad() + weight);
                    droneService.save(drone);
                    Integer qty = loadService.getLoad(drone).get(medicationService.getByCode(code));
                    if (qty != null && qty > 0) {
                        Load load = loadService.getLoadByDroneAndMedication(drone, medicationService.getByCode(code));
                        load.setQuantity(qty + 1);
                        loadService.save(load);
                    } else {
                        Load load = new Load();
                        load.setDrone(drone);
                        load.setMedication(medicationService.getByCode(code));
                        load.setQuantity(1);
                        loadService.save(load);
                    }
                }
                case "remove" -> {
                    Integer weight = medicationService.getByCode(code).getWeight();
                    int qty = loadService.getLoad(drone).get(medicationService.getByCode(code));
                    drone.setLoad(drone.getLoad() - weight);
                    droneService.save(drone);
                    Load load = loadService.getLoadByDroneAndMedication(drone, medicationService.getByCode(code));
                    load.setQuantity(qty - 1);
                    loadService.save(load);
                }
            }
        }

        if (drone == null) return new ModelAndView("drones");

        drone = droneService.getById(id);

        List<Medication> medications = medicationService.getAllMedications();
        Map<Medication, Integer> loads = loadService.getLoad(drone);

        ModelAndView mav = new ModelAndView("drone");

        mav.addObject("helloString", helloString);
        mav.addObject("drone", drone);
        mav.addObject("medications", medications);
        mav.addObject("loads", loads);
        mav.addObject("errMsg", errMsg);

        return mav;
    }

    @GetMapping("drone-new")
    public ModelAndView newDrone() {

        Drone drone = new Drone(droneService.getNextId(), DroneType.LIGHT, 0, 100, 100, DroneState.IDLE);

        ModelAndView mav = new ModelAndView("drone");

        mav.addObject("helloString", helloString);
        mav.addObject("drone", drone);

        return mav;
    }

}