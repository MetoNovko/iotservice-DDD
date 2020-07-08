package com.iotservice.devicemanagement.domain.model.device;

import com.iotservice.devicemanagement.domain.model.measurement.Measurement;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "devices")
@Getter
public class Device {

    @Version
    private long version;

    @Id
    private DeviceId id;

    private DeviceSecret secretKey;

    private DeviceModel model;

    private DeviceDescription description;

    private boolean isPublic;

    private DeviceLocation location;

    private DeviceOwnerId deviceOwner;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    private Set<Measurement> measurements;

    public Device(DeviceSecret secretKey, DeviceModel model, DeviceDescription description, boolean isPublic, DeviceLocation location, DeviceOwnerId deviceOwner, Set<Measurement> measurements) {
        this.secretKey = secretKey;
        this.model = model;
        this.description = description;
        this.isPublic = isPublic;
        this.deviceOwner = deviceOwner;
        this.measurements = measurements;
        this.location = location;
    }

    public Device() {
    }

    public void setId(DeviceId id) {
        this.id = id;
    }

    public void setSecretKey(DeviceSecret secretKey) {
        this.secretKey = secretKey;
    }

    public void setModel(DeviceModel model) {
        this.model = model;
    }


    public void setDescription(DeviceDescription description) {
        this.description = description;
    }

    public void setMeasurements(Set<Measurement> measurements) {
        this.measurements = measurements;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public void setDeviceOwner(DeviceOwnerId deviceOwner) {
        this.deviceOwner = deviceOwner;
    }
}