package com.nemirovsky.dronedispatcher.model;

public enum DroneType {
    LIGHT("Lightweight"), // 0
    MIDDLE("Middleweight"),
    CRUISER("Cruiserweight"),
    HEAVY("Heavyweight");

    private final String displayValue;

    private DroneType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
