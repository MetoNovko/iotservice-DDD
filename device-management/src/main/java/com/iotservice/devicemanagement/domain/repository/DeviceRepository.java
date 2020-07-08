package com.iotservice.devicemanagement.domain.repository;

import com.iotservice.devicemanagement.domain.model.device.Device;
import com.iotservice.devicemanagement.domain.model.device.DeviceId;
import com.iotservice.devicemanagement.domain.model.device.DeviceOwnerId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DeviceRepository extends JpaRepository<Device, DeviceId> {

    Set<Device> findByDeviceOwner(DeviceOwnerId deviceOwnerId);
}
