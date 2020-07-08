package com.iotservice.devicemanagement.application;

import com.iotservice.devicemanagement.domain.model.device.DeviceId;
import com.iotservice.devicemanagement.domain.model.device.DeviceOwner;

public interface UserCatalog {
    DeviceOwner findByDeviceId(DeviceId id);
}
