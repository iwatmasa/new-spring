package com.example.spring_boot_test.repository;

import java.util.List;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.example.spring_boot_test.model.EmployeeInfo;

public interface IEmployeeInfoRepository {

    @Nullable
    EmployeeInfo getEmployeeInfo(@NonNull final String id);

    List<EmployeeInfo> getAllEmployeeInfo();

    @Nullable
    EmployeeInfo addEmployeeInfo(@NonNull final EmployeeInfo employeeInfo);

    @Nullable
    EmployeeInfo removeEmployeeInfo(@NonNull final EmployeeInfo removeEmployeeInfo);

}
