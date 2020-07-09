package com.iotservice.usermanagement.application.forms;

import com.iotservice.usermanagement.domain.model.*;
import lombok.Getter;
import lombok.NonNull;

import java.io.Serializable;

@Getter
public class UserForm implements Serializable {

    @NonNull
    private UserEmail userEmail;

    @NonNull
    private UserName userName;

    @NonNull
    private UserPassword userPassword;

}
