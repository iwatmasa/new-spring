package com.example.spring_boot_test.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Qiitaのユーザ情報です。
 */
@Builder(builderClassName = "Builder")
@Getter
@ToString
public class QiitaUserInfoView {

    private final String id;

    private final String qiitaId;

    private final int itemsCount;

    private final String websiteUrl;

    /**
     * カスタムビルダーです。
     */
    public static class Builder {

        public Builder id(String id) {
            this.id = id;
            return qiitaId(id);
        }
    }
}
