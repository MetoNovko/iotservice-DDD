package com.iotservice.usermanagement.application;

import com.iotservice.usermanagement.application.forms.UserForm;
import com.iotservice.usermanagement.domain.model.Device;
import com.iotservice.usermanagement.domain.model.User;
import com.iotservice.usermanagement.domain.model.UserId;
import com.iotservice.usermanagement.domain.repository.UserRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
//import org.omg.CosNaming.NamingContextPackage.NotFound;

import javax.transaction.Transactional;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@Transactional
public class UserCatalog {
    private final UserRepository userRepository;
    private final Validator validator;

    public UserCatalog(UserRepository userRepository, Validator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    public UserId createUser(@NonNull UserForm user) {
        Objects.requireNonNull(user, "user must not be null");
        var constraintViolations = validator.validate(user);

        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The UserForm is not valid", constraintViolations);
        }

        User newUser = userRepository.saveAndFlush(toDomainModel(user));
        return newUser.getId();
    }

    public User findByUserId(String id) throws NotFound {
        return this.userRepository.findById(id)
                .orElseThrow(NotFound::new);
    }

    private User toDomainModel(UserForm deviceForm) {
        return new User(deviceForm.getUserEmail(),
                deviceForm.getUserName(),  deviceForm.getUserPassword(), new HashSet<>());
    }
}
