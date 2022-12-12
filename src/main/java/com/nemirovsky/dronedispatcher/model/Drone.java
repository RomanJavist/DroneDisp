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
    private Integer loadWeight;
    private Integer batteryLeft;
    private String state;
}