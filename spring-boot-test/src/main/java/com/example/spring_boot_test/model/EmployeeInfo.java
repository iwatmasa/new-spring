package com.example.spring_boot_test.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 * 従業員情報を表します。
 */
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EmployeeInfo {
    private String id;
    private String name;
    private String email;
    private String datetime;
}
