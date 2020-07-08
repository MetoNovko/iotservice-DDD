package com.iotservice.devicemanagement.domain.event;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.iotservice.devicemanagement.domain.model.device.DeviceId;
import com.iotservice.sharedkernel.base.DomainEvent;
import lombok.NonNull;

import java.time.Instant;

public class DeviceAdded implements DomainEvent {

    @JsonProperty("deviceId")
    private final DeviceId deviceId;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    @JsonCreator
    public DeviceAdded(@JsonProperty("deviceId") @NonNull DeviceId deviceId,
                       @JsonProperty("occurredOn") @NonNull Instant occurredOn) {

        this.deviceId = deviceId;
        this.occurredOn = occurredOn;
    }

    @Override
    @NonNull
    public Instant occurredOn() {
        return this.occurredOn;
    }

    @NonNull
    public DeviceId deviceId() {
        return this.deviceId;
    }
}
