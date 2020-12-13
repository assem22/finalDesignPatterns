package com.iitu.kz.strategy;

public interface PaymentStrategy {
    Boolean paymentStatus(double payment);
    void paymentDetails();
}
