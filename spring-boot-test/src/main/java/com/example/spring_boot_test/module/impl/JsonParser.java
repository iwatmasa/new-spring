package com.example.spring_boot_test.module.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.example.spring_boot_test.module.IJsonParser;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * JSONパーサ実装クラスです。
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class JsonParser implements IJsonParser {

    /**
     * ObjectMapperです。
     */
    private final ObjectMapper objectMapper;

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public <T> T parse(@NonNull final String str, @NonNull final Class<T> clazz) {
        try {
            return objectMapper.readValue(str, clazz);
        } catch (IOException e) {
            log.error("", e);
            return null;
        }
    }
}
