package com.nemirovsky.dronedispatcher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Drone {
    @Id
    private String id;
    private String model;
    private Integer load;
    private Integer loadMax;
    private Integer batteryLeft;
    private DroneStatus state;
}

enum DroneStatus {
    IDLE,
    LOADING,
    LOADED,
    DELIVERING,
    DELIVERED,
    RETURNING;
}