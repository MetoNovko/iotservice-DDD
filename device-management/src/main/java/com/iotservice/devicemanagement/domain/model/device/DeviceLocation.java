package com.iotservice.devicemanagement.domain.model.device;

import com.iotservice.sharedkernel.base.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@EqualsAndHashCode
@Embeddable
public class DeviceLocation implements ValueObject {

    private double latitude;
    private double longitude;

    public DeviceLocation(double longitude, double latitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public DeviceLocation() {

    }
}
