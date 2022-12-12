package com.nemirovsky.dronedispatcher.repository;

import com.nemirovsky.dronedispatcher.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneJpaRepository extends JpaRepository<Drone, String> {
}
