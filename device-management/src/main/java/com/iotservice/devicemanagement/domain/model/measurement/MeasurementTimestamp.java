package com.iotservice.devicemanagement.domain.model.measurement;

import com.iotservice.sharedkernel.base.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class MeasurementTimestamp implements ValueObject {
    private long unixTimestamp;

    public MeasurementTimestamp(long unixTimestamp) {
        this.unixTimestamp = unixTimestamp;
    }

    public MeasurementTimestamp() {

    }
}
