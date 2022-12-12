package com.nemirovsky.dronedispatcher.service.impl;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.repository.DroneJpaRepository;
import com.nemirovsky.dronedispatcher.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DroneServiceImpl implements DroneService {

    private final DroneJpaRepository droneJpaRepository;

    @Override
    public List<Drone> getAllDrones() {
        return null;
    }

    @Override
    public List<Drone> getAvailableDrones() {
        return null;
    }

    @Override
    public int save(Drone drone) {
        return 0;
    }

    @Override
    public Drone getById(String id) {
        return null;
    }
}
