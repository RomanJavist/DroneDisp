package com.nemirovsky.dronedispatcher.model;

public enum DroneStatus {
    IDLE, // 0
    LOADING,
    LOADED,
    DELIVERING,
    DELIVERED,
    RETURNING;
}
