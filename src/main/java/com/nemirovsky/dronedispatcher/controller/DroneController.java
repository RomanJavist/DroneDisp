package com.nemirovsky.dronedispatcher.controller;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.DroneStatus;
import com.nemirovsky.dronedispatcher.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DroneController {

    @Autowired
    private DroneService droneService;

    private final String helloString = "DroneDispatcher v1.0";

    private final List<Drone> drones = new ArrayList<>();

    @GetMapping("drones")
    public ModelAndView getAllDrones() {

        ModelAndView mav = new ModelAndView("drones");

        drones.addAll(droneService.getAllDrones());
        mav.addObject("helloString", helloString);
        mav.getModelMap().addAttribute("drones", drones);
        mav.addObject("droneCount", droneService.getAllDrones().size());

        return mav;
    }

    @GetMapping("drone/{id}")
    public ModelAndView getDrone(@PathVariable String id) {
//        Drone drone = droneService.getById(id);
        Drone drone = new Drone("D000", "Lightweight", 0, 100, 100, DroneStatus.IDLE);

        ModelAndView mav = new ModelAndView("drone");
        mav.addObject("helloString", helloString);
        mav.addObject("drone", drone);

        return mav;
    }

}