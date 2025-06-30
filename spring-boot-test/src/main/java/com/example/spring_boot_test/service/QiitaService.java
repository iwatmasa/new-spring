package com.example.spring_boot_test.service;

import lombok.RequiredArgsConstructor;
import com.example.spring_boot_test.model.QiitaUserInfo;
import com.example.spring_boot_test.model.QiitaUserInfoView;
import com.example.spring_boot_test.repository.IQiitaRepository;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

/**
 * Qiitaアクセス用のサービスです。
 */
@Service
@RequiredArgsConstructor
public class QiitaService {

    /**
     * Qiitaアクセス用リポジトリです。
     */
    private final IQiitaRepository qiitaRepository;

    /**
     * 処理を実行します。
     *
     * @return 実行結果
     */
    public String execute() {
        QiitaUserInfo userInfo = qiitaRepository.getUserInfo("hrk_okd");
        if (isNull(userInfo)) {
            return null;
        }

        QiitaUserInfoView userInfoView = QiitaUserInfoView.builder()
                .id(userInfo.getId())
                .itemsCount(userInfo.getItemsCount())
                .websiteUrl(userInfo.getWebsiteUrl())
                .build();

        return userInfoView.toString();
    }
}
