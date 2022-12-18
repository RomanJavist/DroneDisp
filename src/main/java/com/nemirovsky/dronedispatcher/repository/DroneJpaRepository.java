package com.nemirovsky.dronedispatcher.repository;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.DroneStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneJpaRepository extends JpaRepository<Drone, String> {
    Drone findByState(DroneStatus state);
}
