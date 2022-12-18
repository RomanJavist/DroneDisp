package com.nemirovsky.dronedispatcher.service.impl;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.DroneState;
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
    public List<Drone> findByState(DroneState state) {
        return droneJpaRepository.findByState(state);
    }

    ;

    @Override
    public Drone save(Drone drone) {
        return droneJpaRepository.save(drone);
    }

    @Override
    public Drone getById(String id) {
        return droneJpaRepository.findById(id).orElse(null);
    }

    @Override
    public String getNextId() {
        String maxId = droneJpaRepository.findMaxIdDrone().getId();
        char lastChar = maxId.charAt(maxId.length() - 1);
        char newlastChar = (char) (lastChar + 1);
        return maxId.substring(0, maxId.length() - 1) + newlastChar;
    };

}
