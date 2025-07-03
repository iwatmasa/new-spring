package com.example.spring_boot_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.spring_boot_test.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmployeeViewController {
    /**
     * 従業員情報サービスです。
     */
    private final EmployeeService employeeService;

    /**
     * 初期表示
     * 
     * @return メイン画面
     */
    @GetMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 登録画面表示
     * 
     * @return 登録画面
     */
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    /**
     * 一覧画面表示
     * 
     * @return 一覧画面
     */
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "list";
    }
}
