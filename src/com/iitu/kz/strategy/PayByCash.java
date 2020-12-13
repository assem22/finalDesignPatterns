package com.iitu.kz.strategy;

import java.util.Scanner;

public class PayByCash implements PaymentStrategy {

    private int cash;
    private double change;

    private Scanner in = new Scanner(System.in);

    @Override
    public Boolean paymentStatus(double payment) {
        if (cash > payment){
            change = cash - payment;
            System.out.println("Your change: " + change + "\nThank you for your purchase!");
            return true;
        }else if (cash == payment){
            System.out.println("Thank you for your purchase!");
            return true;
        }else{
            System.out.println("Insufficient funds");
            return false;
        }
    }

    @Override
    public void paymentDetails() {
        System.out.println("Input money (tg)");
        cash = in.nextInt();
    }
}
