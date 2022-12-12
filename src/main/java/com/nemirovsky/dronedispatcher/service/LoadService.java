package com.nemirovsky.dronedispatcher.service;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.Medication;

import java.util.Map;

public interface LoadService {

    boolean tryToLoad(Drone drone, Medication medication, int quantity);
    Map<Medication, Integer> getLoad(Drone drone);

}
