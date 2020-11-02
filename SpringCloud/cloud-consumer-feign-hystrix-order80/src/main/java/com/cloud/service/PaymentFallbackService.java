package com.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: cgq
 * @Date: 2020/11/2 16:03
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfoOk(Integer id) {
        return "PaymentFallbackService  paymentInfoOk ";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "PaymentFallbackService   paymentInfoTimeOut ";
    }
}
