package com.iotservice.sharedkernel.infra.eventlog;

import com.iotservice.sharedkernel.base.DomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RemoteEventTranslator {

    boolean supports(StoredDomainEvent storedDomainEvent);

    Optional<DomainEvent> translate(StoredDomainEvent remoteEvent);
}

