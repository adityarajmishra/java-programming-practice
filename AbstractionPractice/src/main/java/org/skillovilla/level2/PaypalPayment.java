package org.skillovilla.level2;

public class PaypalPayment implements Payment {
    private final String paypalId;
    private final String email;

    public PaypalPayment(String paypalId, String email) {
        this.paypalId = paypalId;
        this.email = email;
    }

    @Override
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }

    @Override
    public String getPaymentDetails() {
        return "PayPal ID: " + paypalId + ", Email: " + email;
    }

    public String getPaypalId() {
        return paypalId;
    }

    public String getEmail() {
        return email;
    }
}
