package com.nemirovsky.dronedispatcher.controller;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.service.DroneService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class DroneController {

    private DroneService droneService;

    @Value("${program.name}")
    private String programName;

    @Value("${program.version}")
    private String programVersion;

    private final String helloString = programName + " " + programVersion;

    private final List<Drone> drones = new ArrayList<>();

    @GetMapping("drones")
    public String getAllDrones(Model model) {
        drones.addAll(droneService.getAllDrones());
        model.addAttribute(helloString);
        model.addAllAttributes(drones);

        return "drones";
    }

    @GetMapping("drones/{id}")
    public String getDrone(@PathVariable String id, Model model) {
        Drone drone = droneService.getById(id);
        model.addAttribute(helloString);
        model.addAttribute(drone);

        return "drone";
    }

}