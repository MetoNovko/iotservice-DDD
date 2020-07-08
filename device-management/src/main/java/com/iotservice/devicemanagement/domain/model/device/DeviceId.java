package com.iotservice.devicemanagement.domain.model.device;

import com.iotservice.sharedkernel.base.DomainObjectId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class DeviceId extends DomainObjectId {

    public DeviceId() {
        super("");
    }

    public DeviceId(@NonNull String id) {
        super(id);
    }
}
