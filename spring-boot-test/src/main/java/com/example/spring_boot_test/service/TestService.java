package com.example.spring_boot_test.service;

import lombok.RequiredArgsConstructor;
import com.example.spring_boot_test.repository.ITestRepository;
import org.springframework.stereotype.Service;

/**
 * テスト用のサービスです。
 */
@Service
@RequiredArgsConstructor
public class TestService {

    /**
     * テスト用リポジトリです。
     */
    private final ITestRepository testRepository;

    /**
     * 処理を実行します。
     *
     * @return 実行結果
     */
    public String execute() {
        return testRepository.execute();
    }
}
