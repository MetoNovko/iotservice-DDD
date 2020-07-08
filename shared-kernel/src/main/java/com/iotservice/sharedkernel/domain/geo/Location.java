package com.iotservice.sharedkernel.domain.geo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
@MappedSuperclass
@EqualsAndHashCode
public class Location {
    @Column(name = "longitude")
    private double longitude;
    @Column(name = "latitude")
    @Embedded
    private double latitude;

    @SuppressWarnings("unused") // Used by JPA only.
    protected Location() {
    }

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @NonNull
    @JsonProperty("latitude")
    public double latitude() {
        return latitude;
    }

    @NonNull
    @JsonProperty("longitude")
    public double longitude() {
        return longitude;
    }

}
