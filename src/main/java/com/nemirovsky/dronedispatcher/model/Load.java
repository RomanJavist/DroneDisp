package com.nemirovsky.dronedispatcher.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Load {
    @Id // первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // автогенерация
    private long id;
    @OneToOne // вид связи один к одному
    private Drone drone;
    @OneToOne
    private Medication medication;
    private int quantity;
}
