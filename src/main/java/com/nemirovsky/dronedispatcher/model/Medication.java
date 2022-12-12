package com.nemirovsky.dronedispatcher.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Medication {
    @Id
    private String code;
    private String name;
    private Integer weight;
    private String image;
}
