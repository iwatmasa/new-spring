package com.example.spring_boot_test.config.api;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * APIの設定を読み込みます。
 */
@Component
@ConfigurationProperties(prefix = "myapp")
public class ApiConfigProperty {

    /**
     * APIに関する設定です。
     */
    @Setter
    private Map<String, ApiSetting> api;

    /**
     * API設定を取得します。
     *
     * @param apiName API名称
     * @return API設定
     */
    public ApiSetting get(@NonNull final String apiName) {
        return api.get(apiName);
    }

}
