package com.iotservice.devicemanagement.port.client;

import com.iotservice.devicemanagement.application.UserCatalog;
import com.iotservice.devicemanagement.domain.model.device.DeviceId;
import com.iotservice.devicemanagement.domain.model.device.DeviceOwner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UserCatalogClient implements UserCatalog {

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
    public DeviceOwner findByDeviceId(DeviceId id) {
        try {
            return restTemplate.exchange(uri().path("/api/user/" + id.getId()).build().toUri(), HttpMethod.GET,
                    null, new ParameterizedTypeReference<DeviceOwner>() {
                    }).getBody();
        } catch (Exception ex) {
            return null;
        }
    }
}
