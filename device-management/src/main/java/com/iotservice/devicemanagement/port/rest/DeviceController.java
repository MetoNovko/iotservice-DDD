package com.iotservice.devicemanagement.port.rest;

import com.iotservice.devicemanagement.application.DeviceCatalog;
import com.iotservice.devicemanagement.application.UserCatalog;
import com.iotservice.devicemanagement.domain.model.device.Device;
import com.iotservice.devicemanagement.domain.model.device.DeviceId;
import com.iotservice.devicemanagement.domain.model.device.DeviceOwner;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    private final DeviceCatalog deviceCatalog;
    private final UserCatalog userCatalog;

    public DeviceController(DeviceCatalog deviceCatalog, UserCatalog userCatalog) {
        this.deviceCatalog = deviceCatalog;
        this.userCatalog = userCatalog;
    }

    @GetMapping
    public Device findDeviceById(@RequestParam("id") String id) throws NotFound {
        return this.deviceCatalog.findByDevice(id);
    }

    @GetMapping
    public Set<Device> findDeviceByOwnerId(@RequestParam("ownerId") String ownerId) {
        return this.deviceCatalog.findDeviceByOwnerId(ownerId);
    }

    @GetMapping("/owner")
    public DeviceOwner findOwnerByDevice(@RequestParam("deviceId") String deviceId) {
        return this.userCatalog.findByDeviceId(new DeviceId(deviceId));
    }

}
