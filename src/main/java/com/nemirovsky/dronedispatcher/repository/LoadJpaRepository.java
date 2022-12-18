package com.nemirovsky.dronedispatcher.repository;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.Load;
import com.nemirovsky.dronedispatcher.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoadJpaRepository extends JpaRepository<Load, String> {
    List<Load> getLoadsByDrone(Drone drone);

    Load getLoadByDroneAndMedication(Drone drone, Medication medication);
}
