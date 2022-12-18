package com.nemirovsky.dronedispatcher.repository;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DroneJpaRepository extends JpaRepository<Drone, String> {
    List<Drone> findByState(DroneState state);
}
