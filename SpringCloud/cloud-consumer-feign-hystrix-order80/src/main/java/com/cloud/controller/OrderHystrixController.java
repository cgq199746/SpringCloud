package com.cloud.controller;

import com.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/11/2 14:39
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoOk(id);
        log.info("*/*******" + result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //自己定的fallback用下面这么
//    @HystrixCommand(fallbackMethod = "paymenyTimeOutFallBackMethod" , commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
    //自己没有定义的，用全局的，用下面这个
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfoTimeOut(id);
        log.info("*/*******" + result);
        return result;
    }

    public String paymenyTimeOutFallBackMethod(@PathVariable("id") Integer id){
        return "消费者遇到问题了，你看怎么解决吧";
    }

    //全局fallback
    public String Global_FallbackMethod(){
        return "这是全局fallback，证明你错了，你看着办吧";
    }


}
