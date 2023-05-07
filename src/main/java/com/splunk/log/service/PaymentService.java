package com.splunk.log.service;

import com.splunk.log.model.PaymentContext;
import com.splunk.log.model.TransactionHistory;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    Optional<List<TransactionHistory>> doPayment(PaymentContext context);
    Long genUserId();

}
