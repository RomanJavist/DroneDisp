package com.nemirovsky.dronedispatcher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Load {
    @Id
    private String id;
    private Drone drone;
    private Medication medication;
    private int quantity;
}
