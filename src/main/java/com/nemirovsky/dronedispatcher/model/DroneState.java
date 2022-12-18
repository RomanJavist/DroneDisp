package com.nemirovsky.dronedispatcher.model;

public enum DroneState {
    IDLE("Idle"), // 0
    LOADING("Loading"),
    LOADED("Loaded"),
    DELIVERING("Delivering"),
    DELIVERED("Delivered"),
    RETURNING("Returning");

    private final String displayValue;

    private DroneState(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
