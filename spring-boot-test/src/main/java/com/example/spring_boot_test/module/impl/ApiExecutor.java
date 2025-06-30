package com.example.spring_boot_test.module.impl;

import lombok.RequiredArgsConstructor;
import com.example.spring_boot_test.module.IApiExecutor;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * API実行クラスです。
 */
@Component
@RequiredArgsConstructor
public class ApiExecutor implements IApiExecutor {

    /**
     * RestTemplateです。
     */
    private final RestTemplate restTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public String get(@NonNull final String url) {
        URI uri = URI.create(url);

        RequestEntity<?> requestEntity = new RequestEntity<>(HttpMethod.GET, uri);
        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
        return responseEntity.getBody();
    }
}
