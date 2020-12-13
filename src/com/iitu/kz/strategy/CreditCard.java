package com.iitu.kz.strategy;

public class CreditCard {
    private String cardNumber;
    private String expiration;
    private int ccv;
    private double money;

    public CreditCard(String cardNumber, String expiration, int ccv) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.ccv = ccv;
        this.money = 100000;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
