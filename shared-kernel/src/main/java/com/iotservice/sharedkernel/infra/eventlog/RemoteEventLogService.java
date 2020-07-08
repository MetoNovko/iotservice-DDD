package com.iotservice.sharedkernel.infra.eventlog;

import com.iotservice.sharedkernel.base.RemoteEventLog;
import org.springframework.stereotype.Service;

@Service
public interface RemoteEventLogService {

    String source();

    RemoteEventLog currentLog(long lastProcessedId);

}

