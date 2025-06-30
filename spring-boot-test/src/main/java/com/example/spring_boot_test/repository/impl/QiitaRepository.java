package com.example.spring_boot_test.repository.impl;

import com.example.spring_boot_test.config.api.ApiSetting;
import com.example.spring_boot_test.config.api.QiitaApiSetting;
import com.example.spring_boot_test.model.QiitaUserInfo;
import com.example.spring_boot_test.module.IApiExecutor;
import com.example.spring_boot_test.module.IJsonParser;
import com.example.spring_boot_test.repository.IQiitaRepository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import static java.util.Objects.isNull;

/**
 * Qiita APIを実行するための実装レポジトリです。
 */
@Repository
public class QiitaRepository implements IQiitaRepository {

    /**
     * API設定です。
     */
    private final ApiSetting settings;

    /**
     * API実行クラスです。
     */
    private final IApiExecutor apiExecutor;

    /**
     * JSONパーサです。
     */
    private final IJsonParser jsonParser;

    /**
     * コンストラクタです。
     *
     * @param settings    API設定です。
     * @param apiExecutor API実行クラスです。
     */
    public QiitaRepository(@NonNull @QiitaApiSetting final ApiSetting settings,
            @NonNull final IApiExecutor apiExecutor,
            @NonNull final IJsonParser jsonParser) {
        this.settings = settings;
        this.apiExecutor = apiExecutor;
        this.jsonParser = jsonParser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public QiitaUserInfo getUserInfo(@NonNull final String userId) {
        String body = apiExecutor.get(settings.getUrl() + "/api/v2/users/" + userId);
        if (isNull(body)) {
            return null;
        }

        return jsonParser.parse(body, QiitaUserInfo.class);
    }
}
