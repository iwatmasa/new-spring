package com.example.spring_boot_test.module;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * JSONパーサです。
 */
public interface IJsonParser {

    /**
     * 文字列を指定クラスにパースします。
     *
     * @param str   文字列
     * @param clazz 変換先クラス
     * @return 変換後の結果
     */
    @Nullable
    <T> T parse(@NonNull final String str, @NonNull final Class<T> clazz);
}
