package com.iotservice.devicemanagement.domain.model.device;

import com.iotservice.sharedkernel.base.DomainObjectId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class DeviceOwnerId extends DomainObjectId {

    public DeviceOwnerId(@NonNull String id) {
        super(id);
    }

    public DeviceOwnerId() {
        super("");
    }
}
