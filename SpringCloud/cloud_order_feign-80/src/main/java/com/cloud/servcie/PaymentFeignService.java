package com.cloud.servcie;

import com.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-09-02
 **/
@Component
@FeignClient("cgq-cloud-payment-service")
public interface PaymentFeignService {
    @GetMapping("/getPaymentById/{id}")
    CommonResult getId(@PathVariable("id")int id);
}
