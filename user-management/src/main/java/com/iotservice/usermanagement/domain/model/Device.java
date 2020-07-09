package com.iotservice.usermanagement.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Device {
    private String secretKey;

    private String model;

    private String description;

    private boolean isPublic;

    private double longitude;

    private double latitude;

    private User deviceOwner;

    public Device(String secretKey, String model, String description, boolean isPublic, double longitude, double latitude, User deviceOwner) {
        this.secretKey = secretKey;
        this.model = model;
        this.description = description;
        this.isPublic = isPublic;
        this.longitude = longitude;
        this.latitude = latitude;
        this.deviceOwner = deviceOwner;
    }

    public Device() {
    }
}
