package com.cloud.controlelr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/11/10 14:31
 */
@RestController
public class TestControlelr {
    @GetMapping("/testa")
    public String testA(){
        return "testA";
    }

    @GetMapping("/testb")
    public String testB(){
        return "testb";
    }
}
