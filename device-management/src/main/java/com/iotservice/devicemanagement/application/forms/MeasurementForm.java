package com.iotservice.devicemanagement.application.forms;

import com.iotservice.devicemanagement.domain.model.device.DeviceId;
import com.iotservice.devicemanagement.domain.model.measurement.MeasurementCount;
import com.iotservice.devicemanagement.domain.model.measurement.MeasurementTimestamp;
import lombok.Getter;
import lombok.NonNull;

import java.io.Serializable;

@Getter
public class MeasurementForm implements Serializable {

    @NonNull
    private DeviceId deviceId;

    @NonNull
    private MeasurementCount measurementCount;

    @NonNull
    private MeasurementTimestamp measurementTimestamp;
}
