package org.skillovilla.level2;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentTest {

    @Test
    public void testCreditCardPayment() throws Exception {
        // Test CreditCardPayment methods and details
        Class<?> creditCardPaymentClass = Class.forName("org.skillovilla.level2.CreditCardPayment");
        Object creditCardPayment = creditCardPaymentClass.getDeclaredConstructor(String.class, String.class)
                                                        .newInstance("1234567890123456", "Alice");

        Method makePaymentMethod = creditCardPaymentClass.getMethod("makePayment", double.class);
        Method getPaymentDetailsMethod = creditCardPaymentClass.getMethod("getPaymentDetails");
        Method getCardNumberMethod = creditCardPaymentClass.getMethod("getCardNumber");
        Method getCardHolderNameMethod = creditCardPaymentClass.getMethod("getCardHolderName");

        makePaymentMethod.invoke(creditCardPayment, 100.0);
        String paymentDetails = (String) getPaymentDetailsMethod.invoke(creditCardPayment);
        String cardNumber = (String) getCardNumberMethod.invoke(creditCardPayment);
        String cardHolderName = (String) getCardHolderNameMethod.invoke(creditCardPayment);

        assertEquals("Card Number: 1234567890123456, Card Holder: Alice", paymentDetails);
        assertEquals("1234567890123456", cardNumber);
        assertEquals("Alice", cardHolderName);
    }

    @Test
    public void testPaypalPayment() throws Exception {
        // Test PaypalPayment methods and details
        Class<?> paypalPaymentClass = Class.forName("org.skillovilla.level2.PaypalPayment");
        Object paypalPayment = paypalPaymentClass.getDeclaredConstructor(String.class, String.class)
                                                .newInstance("alice123", "alice@example.com");

        Method makePaymentMethod = paypalPaymentClass.getMethod("makePayment", double.class);
        Method getPaymentDetailsMethod = paypalPaymentClass.getMethod("getPaymentDetails");
        Method getPaypalIdMethod = paypalPaymentClass.getMethod("getPaypalId");
        Method getEmailMethod = paypalPaymentClass.getMethod("getEmail");

        makePaymentMethod.invoke(paypalPayment, 150.0);
        String paymentDetails = (String) getPaymentDetailsMethod.invoke(paypalPayment);
        String paypalId = (String) getPaypalIdMethod.invoke(paypalPayment);
        String email = (String) getEmailMethod.invoke(paypalPayment);

        assertEquals("PayPal ID: alice123, Email: alice@example.com", paymentDetails);
        assertEquals("alice123", paypalId);
        assertEquals("alice@example.com", email);
    }
}
