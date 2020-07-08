package com.iotservice.devicemanagement.domain.model.device;

import com.iotservice.sharedkernel.base.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
@EqualsAndHashCode
@Getter
public class DeviceDescription implements ValueObject {

    private String description;

    public DeviceDescription(@NonNull String description) {
        this.description = description;
    }

    public DeviceDescription() {

    }
}
