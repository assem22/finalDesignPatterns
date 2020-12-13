package com.iitu.kz.strategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(){}

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setNavigatorStrategy(PaymentStrategy paymentStrategy) {
        paymentStrategy.paymentDetails();
    }
}
