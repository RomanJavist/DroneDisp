package com.nemirovsky.dronedispatcher.service;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.Medication;

import java.util.List;
import java.util.Map;

public interface DroneService {

    public List<Drone> getAllDrones();

    public List<Drone> getAvailableDrones();
    public int save(Drone drone);

    public Drone getById(String id);

}
