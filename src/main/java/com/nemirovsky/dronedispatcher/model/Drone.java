package com.nemirovsky.dronedispatcher.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Drone {
    @Id
    private String id;
    private String model;
    private Integer load;
    @Column(name = "load_max")
    private Integer loadMax;
    @Column(name = "battery_left")
    private Integer batteryLeft;
    private DroneState state;
}

