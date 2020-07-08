package com.iotservice.devicemanagement.domain.model.measurement;

import com.iotservice.devicemanagement.domain.model.device.DeviceId;
import lombok.Getter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "measurements")
@Getter
public class Measurement {

    @Version
    private long version;

    @Id
    private MeasurementId id;

    private DeviceId device;

    private MeasurementTimestamp timestamp;

    private MeasurementCount count;

    public Measurement(MeasurementTimestamp timestamp, MeasurementCount count, DeviceId device) {
        this.timestamp = timestamp;
        this.count = count;
        this.device = device;
    }

    public Measurement() {
    }

    public void setTimestamp(MeasurementTimestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setCount(MeasurementCount count) {
        this.count = count;
    }

    public void setDeviceId(DeviceId device) {
        this.device = device;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return getId() == that.getId() &&
                getCount() == that.getCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCount());
    }
}