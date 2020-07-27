package com.cloud.service;

import com.cloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Integer id);
}
