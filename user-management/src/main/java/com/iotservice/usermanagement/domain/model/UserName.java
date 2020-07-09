package com.iotservice.usermanagement.domain.model;

import com.iotservice.sharedkernel.base.ValueObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@EqualsAndHashCode
@Embeddable
public class UserName implements ValueObject {

    private String firstName;
    private String lastName;

    public UserName(String firstName, String latitude) {
        this.firstName = latitude;
        this.lastName = lastName;
    }

    public UserName() {

    }
}
