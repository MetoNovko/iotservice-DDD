package com.iotservice.devicemanagement.domain.repository;

import com.iotservice.devicemanagement.domain.model.device.DeviceId;
import com.iotservice.devicemanagement.domain.model.measurement.Measurement;
import com.iotservice.devicemanagement.domain.model.measurement.MeasurementId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface MeasurementRepository extends JpaRepository<Measurement, MeasurementId> {

    Set<Measurement> findByDevice(DeviceId deviceId);
}
