package com.iitu.kz.strategy;

import java.util.Scanner;

public class PayByCard implements PaymentStrategy {

    private Scanner in = new Scanner(System.in);
    private CreditCard creditCard;

    @Override
    public void paymentDetails() {
        System.out.println("Enter the card number:");
        String cardNumber = in.next();
        System.out.println("Enter the card expiration date 'mm/yy':");
        String cardExp = in.next();
        System.out.println("Enter the card CVV code:");
        int cardCvv = in.nextInt();

        creditCard = new CreditCard(cardNumber, cardExp, cardCvv);
    }

    @Override
    public Boolean paymentStatus(double payment) {
        if (creditCard != null){
            System.out.println("Paying " + payment + " using credit card");
            creditCard.setMoney(creditCard.getMoney() - payment);
            return true;
        }
        return false;
    }
}
