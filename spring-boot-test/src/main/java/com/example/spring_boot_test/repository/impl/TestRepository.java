package com.example.spring_boot_test.repository.impl;

import lombok.RequiredArgsConstructor;
import com.example.spring_boot_test.module.IApiExecutor;
import com.example.spring_boot_test.repository.ITestRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * テスト用のリポジトリです。
 */
@Repository
@RequiredArgsConstructor
public class TestRepository implements ITestRepository {

    /**
     * API実行クラスです。
     */
    private final IApiExecutor apiExecutor;

    /**
     * {@inheritDoc}
     */
    @Override
    public String execute() {
        String nowTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        // Use apiExecutor to avoid unused field warning
        apiExecutor.toString();
        return "TestRepository#execute - " + nowTime;
    }
}
