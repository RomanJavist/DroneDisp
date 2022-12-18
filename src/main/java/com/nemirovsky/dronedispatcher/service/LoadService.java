package com.nemirovsky.dronedispatcher.service;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.Load;
import com.nemirovsky.dronedispatcher.model.Medication;

import java.util.Map;

public interface LoadService {

    boolean tryToLoad(Drone drone, Medication medication);

    Map<Medication, Integer> getLoad(Drone drone);

    Load save(Load load);

    void delete(Load load);
    Load getLoadByDroneAndMedication(Drone drone, Medication medication);

}
