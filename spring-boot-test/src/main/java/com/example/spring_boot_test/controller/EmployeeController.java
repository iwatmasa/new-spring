package com.example.spring_boot_test.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_boot_test.model.EmployeeInfo;
import com.example.spring_boot_test.service.EmployeeService;

@RestController
@RequiredArgsConstructor
public class EmployeeController {
    /**
     * 従業員情報サービスです。
     */
    private final EmployeeService employeeService;

    // @RequestMapping(value = "/employee", consumes =
    // MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @RequestMapping(value = "/employee")
    @ResponseBody
    public EmployeeInfo getEmployee(String id) {
        System.out.println("getEmployee called with id: " + id);
        return employeeService.getEmployee(id);
    }

    // @RequestMapping(value = "/employees", consumes =
    // MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @RequestMapping(value = "/employees")
    @ResponseBody
    public List<EmployeeInfo> getEmployees() {
        System.out.println("getEmployees called");
        return employeeService.getEmployees();
    }

    // @RequestMapping(value = "/employee/add", method = RequestMethod.POST)
    @RequestMapping(value = "/employee/add")
    @ResponseBody
    public String addEmployee(@RequestBody EmployeeInfo employeeInfo) {
        System.out.println("addEmployee called with employeeInfo: " + employeeInfo);
        EmployeeInfo addEmployeeInfo = employeeService.addEmployee(employeeInfo);
        if (addEmployeeInfo != null) {
            return "OK " + addEmployeeInfo.getId();
        }
        return "NG";
    }

    @RequestMapping(value = "/employee/remove")
    @ResponseBody
    public String removeEmployee(@RequestBody EmployeeInfo employeeInfo) {
        System.out.println("removeEmployee called with employeeInfo: " + employeeInfo);
        EmployeeInfo removeEmployeeInfo = employeeService.removeEmployee(employeeInfo);
        if (removeEmployeeInfo != null) {
            return "OK " + removeEmployeeInfo.getId();
        }
        return "NG";
    }
}
