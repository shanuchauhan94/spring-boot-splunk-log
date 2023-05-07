package com.splunk.log.service;

import com.splunk.log.model.PaymentContext;
import com.splunk.log.model.TransactionHistory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaymentServiceImpl implements PaymentService {

    Logger logger = LogManager.getLogger(PaymentServiceImpl.class);

    @Override
    public Optional<List<TransactionHistory>> doPayment(PaymentContext context) {

        logger.info("[in service ] doPayment  user id  : {} ", context.getUserId());
        List<TransactionHistory> list = new ArrayList<>();
        TransactionHistory history = new TransactionHistory(UUID.randomUUID().toString(), context.getUserId(), context.getAmount(), new Date(), true);
        TransactionHistory history1 = new TransactionHistory(UUID.randomUUID().toString(), context.getUserId(), context.getAmount(), new Date(), false);
        TransactionHistory history2 = new TransactionHistory(UUID.randomUUID().toString(), context.getUserId(), context.getAmount(), new Date(), true);
        TransactionHistory history3 = new TransactionHistory(UUID.randomUUID().toString(), context.getUserId(), context.getAmount(), new Date(), false);
        list.add(history);
        list.add(history1);
        list.add(history2);
        list.add(history3);

        return Optional.of(list);
    }

    @Override
    public Long genUserId() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextLong()) * 10000 + r.nextLong());
    }
}
