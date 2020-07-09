package com.iotservice.usermanagement.application;

import com.iotservice.usermanagement.domain.model.Device;
import com.iotservice.usermanagement.domain.model.UserId;

import java.util.Set;

public interface DeviceCatalog {
    Set<Device> findByUserId(UserId id);
}
