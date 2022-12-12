package com.nemirovsky.dronedispatcher.service;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.Medication;

import java.util.List;
import java.util.Map;

public interface DroneService {

    List<Drone> getAllDrones();
    List<Drone> getAvailableDrones();
    int save(Drone drone);
    Drone getById(String id);

}
