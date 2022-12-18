package com.nemirovsky.dronedispatcher.service;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.DroneState;

import java.util.List;

public interface DroneService {

    public List<Drone> getAllDrones();

    public List<Drone> findByState(DroneState state);

    public Drone save(Drone drone);

    public Drone getById(String id);

}
