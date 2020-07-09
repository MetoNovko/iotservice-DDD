package com.iotservice.usermanagement.domain.model;

import com.iotservice.sharedkernel.base.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Getter
@EqualsAndHashCode
@Embeddable
public class UserEmail implements ValueObject {

    private String email;

    public UserEmail(@NonNull String email) {
        this.email = email;
    }

    public UserEmail() {

    }
}