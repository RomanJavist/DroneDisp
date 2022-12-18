package com.nemirovsky.dronedispatcher.repository;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.DroneState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DroneJpaRepository extends JpaRepository<Drone, String> {
    List<Drone> findByState(DroneState state);
    @Query(value = "SELECT * from DRONE d ORDER BY d.id DESC LIMIT 1", nativeQuery = true)
    Drone findMaxIdDrone();
}
