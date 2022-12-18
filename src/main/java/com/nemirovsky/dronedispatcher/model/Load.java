package com.nemirovsky.dronedispatcher.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Load {
    @Id
    private String id;
    @OneToOne
    private Drone drone;
    @OneToOne
    private Medication medication;
    private int quantity;
}
