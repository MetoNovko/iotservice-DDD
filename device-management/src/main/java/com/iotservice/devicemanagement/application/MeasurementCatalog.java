package com.iotservice.devicemanagement.application;

import com.iotservice.devicemanagement.application.forms.MeasurementForm;
import com.iotservice.devicemanagement.domain.event.MeasurementAdded;
import com.iotservice.devicemanagement.domain.model.device.DeviceId;
import com.iotservice.devicemanagement.domain.model.measurement.Measurement;
import com.iotservice.devicemanagement.domain.model.measurement.MeasurementId;
import com.iotservice.devicemanagement.domain.repository.MeasurementRepository;
import lombok.NonNull;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Service
@Transactional
public class MeasurementCatalog {

    private final MeasurementRepository measurementRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    private final Validator validator;


    public MeasurementCatalog(MeasurementRepository measurementRepository, ApplicationEventPublisher applicationEventPublisher,
                              Validator validator) {
        this.measurementRepository = measurementRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.validator = validator;
    }

    public MeasurementId createMeasurement(@NonNull MeasurementForm measurement) {
        Objects.requireNonNull(measurement, "Measurement must not be null");
        var constraintViolations = validator.validate(measurement);

        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The MeasurementForm is not valid", constraintViolations);
        }

        Measurement newMeasurement = measurementRepository.saveAndFlush(toDomainModel(measurement));
        applicationEventPublisher.publishEvent(new MeasurementAdded(newMeasurement.getId(), Instant.now()));
        return newMeasurement.getId();
    }

    public Measurement findMeasurementById(@NotEmpty String id) throws NotFound {
        return this.measurementRepository.findById(new MeasurementId(id))
                .orElseThrow(NotFound::new);
    }

    public Set<Measurement> findByDeviceId(@NotEmpty String deviceId) {
        return this.measurementRepository.findByDevice(new DeviceId(deviceId));
    }

    private Measurement toDomainModel(MeasurementForm measurementForm) {
        return new Measurement(measurementForm.getMeasurementTimestamp(), measurementForm.getMeasurementCount(), measurementForm.getDeviceId());
    }

}
