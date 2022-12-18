package com.nemirovsky.dronedispatcher.service.impl;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.DroneStatus;
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
        return droneJpaRepository.findAll();
    }

    @Override
    public List<Drone> getAvailableDrones() {
        return droneJpaRepository.findAll();
    }

    @Override
    public int save(Drone drone) {
        return 0;
    }

    @Override
    public Drone getById(String id) {
        return droneJpaRepository.findById(id).orElse(new Drone("D000", "Lightweight", 0, 100, 100, DroneStatus.IDLE));
    }
}
