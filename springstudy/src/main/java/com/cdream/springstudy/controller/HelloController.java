package com.cdream.springstudy.controller;

import com.cdream.springstudy.properties.DogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cdream_zs
 * 2016-10-30 23:36
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private DogProperties dogProperties;

    @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId) {
        return "id: " + myId;
    }
}
