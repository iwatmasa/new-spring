package com.example.spring_boot_test.module;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * APIインタフェースです。
 */
public interface IApiExecutor {

    /**
     * GETメソッドを実行します。
     *
     * @return 処理結果
     */
    @Nullable
    String get(@NonNull final String url);
}
