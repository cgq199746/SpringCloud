package com.cloud.service.impl;

import com.cloud.dao.PaymentDao;
import com.cloud.entities.Payment;
import com.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        int i = paymentDao.create(payment);
        return i;
    }

    @Override
    public Payment getPaymentById(Integer id) {
        Payment paymentById = paymentDao.getPaymentById(id);
        return paymentById;
    }
}
