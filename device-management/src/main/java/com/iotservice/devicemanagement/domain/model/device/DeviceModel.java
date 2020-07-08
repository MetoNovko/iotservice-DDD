package com.iotservice.devicemanagement.domain.model.device;

import com.iotservice.sharedkernel.base.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Getter
@EqualsAndHashCode
@Embeddable
public class DeviceModel implements ValueObject {

    private String model;
    // more fields could be added, for instance maker, year produced etc.

    public DeviceModel(@NonNull String model) {
        this.model = model;
    }

    public DeviceModel() {

    }
}
