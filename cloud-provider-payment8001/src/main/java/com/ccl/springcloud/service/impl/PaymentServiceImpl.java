package com.ccl.springcloud.service.impl;

import com.ccl.springcloud.dao.PaymentDao;
import com.ccl.springcloud.entities.Payment;
import com.ccl.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
