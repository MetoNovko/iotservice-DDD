package com.iotservice.devicemanagement.domain.model.device;

import com.iotservice.sharedkernel.base.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;
import java.util.UUID;

@Getter
@EqualsAndHashCode
@Embeddable
public class DeviceSecret implements ValueObject {

    private String secret;

    public DeviceSecret(@NonNull String secret) {
        this.secret = secret;
    }

    public DeviceSecret() {
        this.secret = UUID.randomUUID().toString();
    }


}
