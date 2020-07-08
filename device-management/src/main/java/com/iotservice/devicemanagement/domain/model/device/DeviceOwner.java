package com.iotservice.devicemanagement.domain.model.device;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeviceOwner {

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    public DeviceOwner(String username, String email, String firstName, String lastName, String password) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public DeviceOwner() {

    }

}