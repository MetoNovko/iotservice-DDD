package com.iotservice.usermanagement.port.client;


import com.iotservice.usermanagement.application.DeviceCatalog;
import com.iotservice.usermanagement.domain.model.Device;
import com.iotservice.usermanagement.domain.model.User;
import com.iotservice.usermanagement.domain.model.UserId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@Service
public class UserCatalogClient implements DeviceCatalog {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    UserCatalogClient(@Value("${app.user-catalog.url}") String serverUrl,
                      @Value("${app.user-catalog.connect-timeout-ms}") int connectTimeout,
                      @Value("${app.user-catalog.read-timeout-ms}") int readTimeout) {
        this.serverUrl = serverUrl;
        restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        // Never ever do a remote call without a finite timeout!
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(serverUrl);
    }


    @Override
    public Set<Device> findByUserId(UserId id) {
        try {
            return restTemplate.exchange(uri().path("/api/user/" + id.getId()).build().toUri(), HttpMethod.GET,
                    null, new ParameterizedTypeReference<Set<Device>>() {
                    }).getBody();
        } catch (Exception ex) {
            return null;
        }
    }
}
