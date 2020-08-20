package com.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-08-20
 **/
@RestController
@Slf4j
public class paymentController {

    @Value("${server.port}")
    private String serverPort ;

    @GetMapping("")
    public String paymentConsul(){
        return "spring cloud with consul " + serverPort + "\t" + UUID.randomUUID().toString();

    }
}
