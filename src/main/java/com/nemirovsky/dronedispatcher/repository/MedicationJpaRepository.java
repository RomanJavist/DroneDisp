package com.nemirovsky.dronedispatcher.repository;

import com.nemirovsky.dronedispatcher.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationJpaRepository extends JpaRepository<Medication, String> {
}
