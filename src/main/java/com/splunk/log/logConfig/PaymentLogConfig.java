package com.splunk.log.logConfig;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PaymentLogConfig {

    Logger log = LogManager.getLogger(PaymentLogConfig.class);

    @Pointcut("execution(public * com.spring.aop.service.PaymentService..*(..))")
    public void getTransaction() {
        log.info("************** pointcut method executed ********************");
    }

    @Before("getTransaction()")
    public void getBeginTransactionLog() {
        log.info("Before transaction log");
    }

    @After("getTransaction()")
    public void getCompleteTransactionLog() {
        log.info("After transaction log");
    }

    @AfterReturning("getTransaction()")
    public void getCommitTransactionLog() {
        log.info("Commit transaction log");
    }

    @AfterThrowing("getTransaction()")
    public void getRollbackTransactionLog() {
        log.info("Exception transaction log");
    }
}
