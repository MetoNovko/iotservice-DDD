package com.iotservice.usermanagement.domain.model;

import com.iotservice.sharedkernel.base.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Getter
@EqualsAndHashCode
@Embeddable
public class UserPassword implements ValueObject {

    private String password;

    public UserPassword(@NonNull String password) {
        this.password = password;
    }

    public UserPassword() {

    }
}