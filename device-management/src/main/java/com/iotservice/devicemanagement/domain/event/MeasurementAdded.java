package com.iotservice.devicemanagement.domain.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iotservice.devicemanagement.domain.model.measurement.MeasurementId;
import com.iotservice.sharedkernel.base.DomainEvent;
import lombok.NonNull;

import java.time.Instant;

public class MeasurementAdded implements DomainEvent {

    @JsonProperty("measurementId")
    private final MeasurementId measurementId;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public MeasurementAdded(@JsonProperty("measurementId") @NonNull MeasurementId measurementId,
                       @JsonProperty("occurredOn") @NonNull Instant occurredOn) {

        this.measurementId = measurementId;
        this.occurredOn = occurredOn;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return this.occurredOn;
    }

    @NonNull
    public MeasurementId MeasurementId() {
        return this.measurementId;
    }
}
