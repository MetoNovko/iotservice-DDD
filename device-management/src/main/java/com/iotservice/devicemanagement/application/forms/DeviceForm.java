package com.iotservice.devicemanagement.application.forms;

import com.iotservice.devicemanagement.domain.model.device.*;
import lombok.Getter;
import lombok.NonNull;

import java.io.Serializable;

@Getter
public class DeviceForm implements Serializable {

    @NonNull
    private DeviceModel deviceModel;

    @NonNull
    private DeviceLocation deviceLocation;

    @NonNull
    private DeviceSecret deviceSecret;

    @NonNull
    private DeviceOwnerId deviceOwnerId;

    @NonNull
    private DeviceDescription deviceDescription;

    @NonNull
    private boolean isPublic;
}
