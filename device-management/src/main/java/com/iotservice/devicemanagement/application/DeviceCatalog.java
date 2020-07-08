package com.iotservice.devicemanagement.application;

import com.iotservice.devicemanagement.application.forms.DeviceForm;
import com.iotservice.devicemanagement.domain.event.DeviceAdded;
import com.iotservice.devicemanagement.domain.model.device.Device;
import com.iotservice.devicemanagement.domain.model.device.DeviceId;
import com.iotservice.devicemanagement.domain.model.device.DeviceOwnerId;
import com.iotservice.devicemanagement.domain.model.device.DeviceSecret;
import com.iotservice.devicemanagement.domain.repository.DeviceRepository;
import lombok.NonNull;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@Transactional
public class DeviceCatalog {

    private final DeviceRepository deviceRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    private final Validator validator;


    public DeviceCatalog(DeviceRepository deviceRepository, ApplicationEventPublisher applicationEventPublisher,
                         Validator validator) {
        this.deviceRepository = deviceRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.validator = validator;
    }

    public DeviceId createDevice(@NonNull DeviceForm device) {
        Objects.requireNonNull(device, "device must not be null");
        var constraintViolations = validator.validate(device);

        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The DeviceForm is not valid", constraintViolations);
        }

        Device newDevice = deviceRepository.saveAndFlush(toDomainModel(device));
        applicationEventPublisher.publishEvent(new DeviceAdded(newDevice.getId(), Instant.now()));
        return newDevice.getId();
    }

    public Device findByDevice(String id) throws NotFound {
        return this.deviceRepository.findById(new DeviceId(id))
                .orElseThrow(NotFound::new);
    }

    public Set<Device> findDeviceByOwnerId(String ownerId) {
        return this.deviceRepository.findByDeviceOwner(new DeviceOwnerId(ownerId));
    }

    private Device toDomainModel(DeviceForm deviceForm) {
        return new Device(new DeviceSecret(), deviceForm.getDeviceModel(),
                deviceForm.getDeviceDescription(), deviceForm.isPublic(),
                deviceForm.getDeviceLocation(), deviceForm.getDeviceOwnerId(), new HashSet<>());
    }

}
