package com.example.demo.controller;

import com.example.demo.core.DefaultParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by whydd on 2017-07-14.
 */
@Controller
@Slf4j
public class CommonController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/error")
    public String error() {
        return "error";
    }

    @GetMapping(value = "/test")
    public String test(DefaultParams defaultParams) {
        log.info("defaultParams.toString() : : : " + defaultParams.toString());
        return "test";
    }
}
