package com.cloud.servcie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-09-02
 **/
@Service
@FeignClient("cgq-cloud-payment-service")
public interface PaymentFeignService {
}
