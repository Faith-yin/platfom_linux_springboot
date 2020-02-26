package com.ypf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, this is my first test";
    }

    @RequestMapping("/getMap")
    public Map<Object,String> getMap() {
        Map<Object,String> map = new HashMap<>();
        map.put("status", "200");
        map.put("result", "success");
        map.put("data", "Hello, you have get my information");
        return map;
    }

}














