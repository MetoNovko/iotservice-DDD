package com.iotservice.devicemanagement.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String secretKey;

    private String model;

    private String description;

    private boolean isPublic;

    private double longitude;

    private double latitude;

    @ManyToOne(fetch = FetchType.LAZY)
    private User deviceOwner;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "device")
    private Set<Measurement> measurements;

    public Device(String secretKey, String model, String description, boolean isPublic, double longitude, double latitude, User deviceOwner, Set<Measurement> measurements) {
        this.secretKey = secretKey;
        this.model = model;
        this.description = description;
        this.isPublic = isPublic;
        this.longitude = longitude;
        this.latitude = latitude;
        this.deviceOwner = deviceOwner;
        this.measurements = measurements;
    }

    public Device() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Measurement> getMeasurements() {
        return measurements;
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

    public User getDeviceOwner() {
        return deviceOwner;
    }

    public void setDeviceOwner(User deviceOwner) {
        this.deviceOwner = deviceOwner;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
