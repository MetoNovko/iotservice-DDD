package com.iotservice.devicemanagement.domain.model.measurement;

import com.iotservice.sharedkernel.base.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class MeasurementCount implements ValueObject {

    private int count;
    private String unit;

    public MeasurementCount(int count, String unit) {
        this.count = count;
        this.unit = unit;
    }

    public MeasurementCount() {
    }

}
