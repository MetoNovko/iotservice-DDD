package com.iotservice.devicemanagement.domain.model.measurement;

import com.iotservice.sharedkernel.base.DomainObjectId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class MeasurementId extends DomainObjectId {

    public MeasurementId() {
        super("");
    }

    public MeasurementId(@NonNull String id) {
        super(id);
    }
}
