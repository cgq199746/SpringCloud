package com.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/11/2 13:47
 */
@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfoOk(Integer id){
        return "线程池 " + Thread.currentThread().getName()+ " paymentInfoOk,id: " + id;
    }

    /**
     * 服务降级
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOut_Handler" , commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentInfoTimeOut(Integer id){
        //int  i = 2/0;
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池 " + Thread.currentThread().getName()+ " paymentInfoTimeOut,id: " + id + " 耗时三秒钟";
    }

    public String paymentInfoTimeOut_Handler(Integer id){
        return "有问题了，没办法  " + id ;
    }

    //===========================服务熔断================================
    @HystrixCommand(fallbackMethod = "paymentCircutBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircutBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("******id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功，uuid：" + serialNumber;

    }

    public String paymentCircutBreaker_fallback(@PathVariable("id") Integer id){

        return "id不能为负数";

    }




}
