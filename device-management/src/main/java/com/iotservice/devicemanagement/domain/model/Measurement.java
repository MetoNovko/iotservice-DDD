package com.iotservice.devicemanagement.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    private Device device;

    private long timestamp;

    private int count;

    public Measurement(long timestamp, int count, Device device) {
        this.timestamp = timestamp;
        this.count = count;
        this.device = device;
    }

    public Measurement() {
    }

    public long getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Device getDevice() {
        return this.device;
    }

    public void setDeviceId(Device device) {
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