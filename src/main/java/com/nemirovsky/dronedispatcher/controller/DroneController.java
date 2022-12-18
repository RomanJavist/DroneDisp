package com.nemirovsky.dronedispatcher.controller;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.DroneState;
import com.nemirovsky.dronedispatcher.model.DroneType;
import com.nemirovsky.dronedispatcher.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DroneController {

    @Autowired
    private DroneService droneService;

    private final String helloString = "DroneDispatcher v1.0";

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
                                 @RequestParam(required = false, name = "save") boolean save,
                                 @ModelAttribute("drone") Drone newDrone) {

        Drone drone = droneService.getById(id);

        if (save) {
            droneService.save(newDrone);
            drone = newDrone;
        }

        if (drone == null) return new ModelAndView("drones");

        ModelAndView mav = new ModelAndView("drone");

        mav.addObject("helloString", helloString);
        mav.addObject("drone", drone);

        return mav;
    }
    @GetMapping("drone-new")
    public ModelAndView newDrone() {

        Drone drone = new Drone(droneService.getNextId(), DroneType.LIGHT, 0, 100,100, DroneState.IDLE);

        ModelAndView mav = new ModelAndView("drone");

        mav.addObject("helloString", helloString);
        mav.addObject("drone", drone);

        return mav;
    }

}