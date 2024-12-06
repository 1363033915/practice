package com.zhu.practice.controller;

import com.zhu.practice.common.domain.response.RES;
import com.zhu.practice.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/>
 * Created by cl_zhu on 2024/12/6
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/hello")
    public RES hello() {
        return RES.success(testService.selectList());
    }

    @RequestMapping("/insert")
    public RES insert() {
        return RES.success(testService.insert());
    }
}
