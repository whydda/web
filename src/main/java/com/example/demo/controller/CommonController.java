package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by whydd on 2017-07-14.
 */
@Controller
public class CommonController {

    @GetMapping(value = "/")
    public String index(){
        return "index";
    }
}
