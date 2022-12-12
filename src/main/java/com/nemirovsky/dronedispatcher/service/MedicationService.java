package com.nemirovsky.dronedispatcher.service;

import com.nemirovsky.dronedispatcher.model.Drone;
import com.nemirovsky.dronedispatcher.model.Medication;

import java.util.List;

public interface MedicationService {

    List<Medication> getAllMedications();
    Medication getByCode(String code);

}
