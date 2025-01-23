package com.nemirovsky.dronedispatcher.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
@Data // автогенерация сеттеров, геттеров и т.д.
@Entity // сущность
@AllArgsConstructor // генерирует конструктор для всех полей
@NoArgsConstructor // конструктор без параметров
public class Drone {
    @Id // первичный ключ
    private String id;
    private DroneType type;
    private Integer load;
    @Column(name = "load_max") // значение будет хранится в соответствуеющей колонке БД
    private Integer loadMax;
    @Column(name = "battery_left") // значение будет хранится в соответствуеющей колонке БД
    private Integer batteryLeft;
    private DroneState state;
}

