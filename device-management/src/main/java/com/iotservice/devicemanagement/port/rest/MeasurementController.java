package com.iotservice.devicemanagement.port.rest;

import com.iotservice.devicemanagement.application.MeasurementCatalog;
import com.iotservice.devicemanagement.domain.model.measurement.Measurement;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/measurement")
public class MeasurementController {

    private final MeasurementCatalog measurementCatalog;

    public MeasurementController(MeasurementCatalog measurementCatalog) {
        this.measurementCatalog = measurementCatalog;
    }

    @GetMapping
    public Measurement findMeasurementById(@RequestParam("id") String id) throws NotFound {
        return measurementCatalog.findMeasurementById(id);
    }

    @GetMapping
    public Set<Measurement> findMeasurementByDeviceId(@RequestParam("deviceId") String deviceId) {
        return measurementCatalog.findByDeviceId(deviceId);
    }

}
