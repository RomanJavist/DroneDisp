package com.nemirovsky.dronedispatcher.service.impl;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.Medication;
import com.nemirovsky.dronedispatcher.repository.DroneJpaRepository;
import com.nemirovsky.dronedispatcher.service.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoadServiceImpl implements LoadService {

    private final DroneJpaRepository droneJpaRepository;

    @Override
    public boolean tryToLoad(Drone drone, Medication medication, int quantity) {
        return false;
    }

    @Override
    public Map<Medication, Integer> getLoad(Drone drone) {
        return null;
    }
}
