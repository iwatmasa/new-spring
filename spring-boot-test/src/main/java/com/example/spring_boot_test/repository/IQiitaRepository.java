package com.example.spring_boot_test.repository;

import com.example.spring_boot_test.model.QiitaUserInfo;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Quuita APIを実行するためのレポジトリインタフェースです。
 */
public interface IQiitaRepository {

    /**
     * ユーザ情報を取得します。
     *
     * @param userId ユーザID
     * @return 処理結果
     */
    @Nullable
    QiitaUserInfo getUserInfo(@NonNull final String userId);
}
