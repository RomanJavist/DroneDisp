package com.nemirovsky.dronedispatcher.service.impl;

import com.nemirovsky.dronedispatcher.model.Medication;
import com.nemirovsky.dronedispatcher.repository.MedicationJpaRepository;
import com.nemirovsky.dronedispatcher.service.MedicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationServiceImpl implements MedicationService {

    private final MedicationJpaRepository medicationJpaRepository;

    @Override
    public List<Medication> getAllMedications() {
        return medicationJpaRepository.findAll();
    }

    @Override
    public Medication getByCode(String code) {
        return medicationJpaRepository.findById(code).orElse(null);
    }
}
