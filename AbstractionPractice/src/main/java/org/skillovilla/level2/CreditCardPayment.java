package org.skillovilla.level2;

public class CreditCardPayment implements Payment {
    private final String cardNumber;
    private final String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }

    @Override
    public String getPaymentDetails() {
        return "Card Number: " + cardNumber + ", Card Holder: " + cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }
}
