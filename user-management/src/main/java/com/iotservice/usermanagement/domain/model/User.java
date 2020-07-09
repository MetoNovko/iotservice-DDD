package com.iotservice.usermanagement.domain.model;

import lombok.Getter;

import javax.persistence.*;

import java.util.Set;

@Getter
@Entity
@Table(name = "USERS")
public class User {

    @Version
    private long version;

    @Id
    private UserId id;

    @Column(unique = true)
    private UserEmail email;

    private UserName name;

    private UserPassword password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deviceOwner")
    private Set<DeviceId> devices;

    public User(UserEmail email, UserName name, UserPassword password, Set<DeviceId> devices) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.devices = devices;
    }

    public User() {

    }

    public void setId(UserId id) {
        this.id = id;
    }

    public void setEmail(UserEmail email) {
        this.email = email;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public void setPassword(UserPassword password) {
        this.password = password;
    }

    public void setDevices(Set<DeviceId> devices) {
        this.devices = devices;
    }
}
