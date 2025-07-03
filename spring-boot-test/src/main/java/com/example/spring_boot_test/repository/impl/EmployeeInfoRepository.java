package com.example.spring_boot_test.repository.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.example.spring_boot_test.model.EmployeeInfo;
import com.example.spring_boot_test.repository.IEmployeeInfoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class EmployeeInfoRepository implements IEmployeeInfoRepository {
    private static final String DATA_FILE_PATH = "data/EmployeeInfo.json";

    @Override
    public EmployeeInfo getEmployeeInfo(@NonNull final String id) {
        ObjectMapper objectMapper = new ObjectMapper();
        File dataFile = new File(DATA_FILE_PATH);
        List<EmployeeInfo> employeeInfoList = null;
        try {
            employeeInfoList = objectMapper.readValue(dataFile,
                    new TypeReference<List<EmployeeInfo>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        for (EmployeeInfo employeeInfo : employeeInfoList) {
            if (employeeInfo.getId().equals(id)) {
                System.out.println("Get employee info: " + employeeInfo);
                return employeeInfo;
            }
        }
        return null;
    }

    @Override
    public List<EmployeeInfo> getAllEmployeeInfo() {
        ObjectMapper objectMapper = new ObjectMapper();
        File dataFile = new File(DATA_FILE_PATH);
        List<EmployeeInfo> employeeInfoList = null;
        try {
            employeeInfoList = objectMapper.readValue(dataFile,
                    new TypeReference<List<EmployeeInfo>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
            employeeInfoList = new ArrayList<>();
        }
        return employeeInfoList;
    }

    @Override
    public EmployeeInfo addEmployeeInfo(@NonNull final EmployeeInfo employeeInfo) {
        ObjectMapper objectMapper = new ObjectMapper();
        File dataFile = new File(DATA_FILE_PATH);
        List<EmployeeInfo> employeeInfoList = null;
        try {
            employeeInfoList = objectMapper.readValue(dataFile,
                    new TypeReference<List<EmployeeInfo>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
            employeeInfoList = new ArrayList<>();
        }
        System.out.println("Add employee info: " + employeeInfo);
        employeeInfoList.add(employeeInfo);

        try {
            // オブジェクトをJSON形式でファイルに書き込む
            objectMapper.writeValue(new File(DATA_FILE_PATH), employeeInfoList);
            System.out.println("JSONファイルにデータを書き込みました。");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return employeeInfo;
    }

    @Override
    public EmployeeInfo removeEmployeeInfo(@NonNull final EmployeeInfo removeEmployeeInfo) {
        // JacksonのObjectMapperインスタンスを作成
        ObjectMapper objectMapper = new ObjectMapper();

        File dataFile = new File(DATA_FILE_PATH);
        List<EmployeeInfo> employeeInfoList = null;
        try {
            employeeInfoList = objectMapper.readValue(dataFile,
                    new TypeReference<List<EmployeeInfo>>() {
                    });
        } catch (IOException e) {
            e.printStackTrace();
            employeeInfoList = new ArrayList<>();
        }

        for (EmployeeInfo employeeInfo : employeeInfoList) {
            if (employeeInfo.getId().equals(removeEmployeeInfo.getId())
                    && employeeInfo.getName().equals(removeEmployeeInfo.getName())
                    && employeeInfo.getEmail().equals(removeEmployeeInfo.getEmail())
                    && employeeInfo.getDatetime().equals(removeEmployeeInfo.getDatetime())) {
                // 一致する従業員情報を削除
                System.out.println("Remove employee info: " + employeeInfo);
                employeeInfoList.remove(employeeInfo);
                try {
                    // オブジェクトをJSON形式でファイルに書き込む
                    objectMapper.writeValue(new File(DATA_FILE_PATH), employeeInfoList);
                    System.out.println("JSONファイルにデータを書き込みました。");
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
                return employeeInfo;
            }
        }
        return null;
    }
}
