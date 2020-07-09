package com.iotservice.usermanagement.port.rest;


import com.iotservice.usermanagement.application.DeviceCatalog;
import com.iotservice.usermanagement.application.UserCatalog;
import com.iotservice.usermanagement.domain.model.Device;
import com.iotservice.usermanagement.domain.model.User;
import com.iotservice.usermanagement.domain.model.UserId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final DeviceCatalog deviceCatalog;
    private final UserCatalog userCatalog;

    public UserController(DeviceCatalog deviceCatalog, UserCatalog userCatalog) {
        this.deviceCatalog = deviceCatalog;
        this.userCatalog = userCatalog;
    }

    @GetMapping
    public User findUserById(@RequestParam("id") String id) throws Exception {
        return this.userCatalog.findByUserId(id);
    }

    @GetMapping
    public Set<Device> findDeviceByOwnerId(@RequestParam("ownerId") String ownerId) {
        return this.deviceCatalog.findByUserId(new UserId(ownerId));
    }


}