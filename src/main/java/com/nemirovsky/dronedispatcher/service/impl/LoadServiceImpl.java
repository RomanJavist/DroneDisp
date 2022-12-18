package com.nemirovsky.dronedispatcher.service.impl;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.Load;
import com.nemirovsky.dronedispatcher.model.Medication;
import com.nemirovsky.dronedispatcher.repository.DroneJpaRepository;
import com.nemirovsky.dronedispatcher.repository.LoadJpaRepository;
import com.nemirovsky.dronedispatcher.service.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoadServiceImpl implements LoadService {

    private final LoadJpaRepository loadJpaRepository;

    @Override
    public boolean tryToLoad(Drone drone, Medication medication) {
        return false;
    }

    @Override
    public Map<Medication, Integer> getLoad(Drone drone) {
        return loadJpaRepository.getLoadsByDrone(drone).stream().collect(Collectors.toMap(Load::getMedication, Load::getQuantity));
    }
    @Override
    public Load save(Load load) {
        return loadJpaRepository.save(load);
    }

    @Override
    public Load getLoadByDroneAndMedication(Drone drone, Medication medication) {
        return loadJpaRepository.getLoadByDroneAndMedication(drone, medication);
    }
}
