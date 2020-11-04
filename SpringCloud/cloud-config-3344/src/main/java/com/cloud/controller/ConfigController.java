package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/11/4 14:03
 */
@RestController
public class ConfigController {

    @Value("${server.port}")
    private String port;

    @Value("${config.info}")
    private String config;

    @GetMapping("/config")
    public String config(){
        return config + port ;
    }
}
