package com.example.spring_boot_test.service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.spring_boot_test.model.EmployeeInfo;
import com.example.spring_boot_test.repository.IEmployeeInfoRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final IEmployeeInfoRepository employeeInfoRepository;

    private boolean isValidId(String id) {
        // IDの空文字チェック
        if (!StringUtils.hasText(id)) {
            System.out.println("addEmployee called with empty id");
            return false;
        }
        // IDの半角数字チェック
        if (!id.matches("^[0-9]+$")) {
            System.out.println("addEmployee called with non-numeric id");
            return false;
        }
        // IDの長さチェック(7文字)
        if (id.length() != 7) {
            System.out.println("addEmployee called with invalid id length");
            return false;
        }
        return true;
    }

    private boolean isValidEmployee(EmployeeInfo employee) {
        // employeeがnullチェック
        if (employee == null) {
            System.out.println("addEmployee called with empty employee");
            return false;
        }
        // IDの空文字チェック
        if (!StringUtils.hasText(employee.getId())) {
            System.out.println("addEmployee called with empty id");
            return false;
        }
        // IDの半角数字チェック
        if (!employee.getId().matches("^[0-9]+$")) {
            System.out.println("addEmployee called with non-numeric id");
            return false;
        }
        // IDの長さチェック(7文字)
        if (employee.getId().length() != 7) {
            System.out.println("addEmployee called with invalid id length");
            return false;
        }
        // 名前の空文字チェック
        if (!StringUtils.hasText(employee.getName())) {
            System.out.println("addEmployee called with empty name");
            return false;
        }
        // 名前の全角文字チェック
        if (!employee.getName().matches("^[^ -~｡-ﾟ]+$")) {
            System.out.println("addEmployee called with non-fullwidth name");
            return false;
        }
        // 名前の長さチェック(10文字以下)
        if (employee.getName().length() > 10) {
            System.out.println("addEmployee called with long name");
            return false;
        }
        // メールの空文字チェック
        if (!StringUtils.hasText(employee.getEmail())) {
            System.out.println("addEmployee called with empty email");
            return false;
        }
        // メールの形式チェック
        if (!employee.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("addEmployee called with invalid email format");
            return false;
        }
        // メールの長さチェック
        if (employee.getEmail().length() > 254) {
            System.out.println("addEmployee called with long email");
            return false;
        }
        // 日時の空文字チェック
        if (!StringUtils.hasText(employee.getDatetime())) {
            System.out.println("addEmployee called with empty datetime");
            return false;
        }
        // 日時の形式チェック
        if (!employee.getDatetime().matches("^\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}:\\d{2}$")) {
            System.out.println("addEmployee called with invalid datetime format");
            return false;
        }
        return true;
    }

    public EmployeeInfo getEmployee(String id) {
        // パラメータチェック
        if (!this.isValidId(id)) {
            System.out.println("getEmployee called with invalid id");
            return null;
        }

        return employeeInfoRepository.getEmployeeInfo(id);
    }

    public List<EmployeeInfo> getEmployees() {
        return employeeInfoRepository.getAllEmployeeInfo();
    }

    public EmployeeInfo addEmployee(EmployeeInfo employee) {
        // パラメータチェック
        if (!isValidEmployee(employee)) {
            System.out.println("addEmployee called with invalid employee");
            return null;
        }

        return employeeInfoRepository.addEmployeeInfo(employee);
    }

    public EmployeeInfo removeEmployee(EmployeeInfo employee) {
        // パラメータチェック
        if (!isValidEmployee(employee)) {
            System.out.println("removeEmployee called with invalid employee");
            return null;
        }
        return employeeInfoRepository.removeEmployeeInfo(employee);
    }
}
