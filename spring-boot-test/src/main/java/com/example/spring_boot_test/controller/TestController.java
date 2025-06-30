package com.example.spring_boot_test.controller;

import lombok.RequiredArgsConstructor;
import com.example.spring_boot_test.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * テスト用のコントローラです。
 */
@Controller
@RequiredArgsConstructor
public class TestController {

    /**
     * テストサービスです。
     */
    private final TestService testService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return testService.execute();
    }

}
