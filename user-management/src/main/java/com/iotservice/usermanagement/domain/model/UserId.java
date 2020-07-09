package com.iotservice.usermanagement.domain.model;

import com.iotservice.sharedkernel.base.DomainObjectId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@EqualsAndHashCode
public class UserId extends DomainObjectId {

    public UserId() {
        super("");
    }

    public UserId(@NonNull String id) {
        super(id);
    }
}
