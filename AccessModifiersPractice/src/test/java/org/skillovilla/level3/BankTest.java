package org.skillovilla.level3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankTest {

    @Test
    public void testAccessAccount() throws Exception {
//        // Access the Bank class and its accessAccount method
//        Class<?> bankClass = Class.forName("org.skillovilla.level3.Bank");
//        Object bank = bankClass.getDeclaredConstructor().newInstance();
//        Method accessAccountMethod = bankClass.getMethod("accessAccount");
//        accessAccountMethod.invoke(bank);
//
//        // Access the Account class and its methods
//        Class<?> accountClass = Class.forName("org.skillovilla.level3.Account");
//        Object account = accountClass.getDeclaredConstructor().newInstance();
//
//        // Set and get the account number
//        Method setAccountNumberMethod = accountClass.getMethod("setAccountNumber", String.class);
//        Method getAccountNumberMethod = accountClass.getMethod("getAccountNumber");
//        setAccountNumberMethod.invoke(account, "111222333");
//        String accountNumber = (String) getAccountNumberMethod.invoke(account);
//        assertEquals("111222333", accountNumber);
//
//        // Set and get the balance
//        Method setBalanceMethod = accountClass.getMethod("setBalance", double.class);
//        Method getBalanceMethod = accountClass.getMethod("getBalance");
//        setBalanceMethod.invoke(account, 1000.0);
//        double balance = (double) getBalanceMethod.invoke(account);
//        assertEquals(1000.0, balance);
        // Create an instance of the Bank class
        Class<?> bankClass = Class.forName("org.skillovilla.level3.Bank");
        Object bank = bankClass.getDeclaredConstructor().newInstance();

        // Access the accessAccount method with parameters
        Method accessAccountMethod = bankClass.getMethod("accessAccount", String.class, double.class);

        // Invoke the accessAccount method with test values
        accessAccountMethod.invoke(bank, "111222333", 1000.0);

        // Create an instance of the Account class
        Class<?> accountClass = Class.forName("org.skillovilla.level3.Account");
        Object account = accountClass.getDeclaredConstructor().newInstance();

        // Set the accountNumber and balance using the accessAccount method
        Method setAccountNumberMethod = accountClass.getMethod("setAccountNumber", String.class);
        Method setBalanceMethod = accountClass.getMethod("setBalance", double.class);
        setAccountNumberMethod.invoke(account, "111222333");
        setBalanceMethod.invoke(account, 1000.0);

        // Get the accountNumber and balance
        Method getAccountNumberMethod = accountClass.getMethod("getAccountNumber");
        Method getBalanceMethod = accountClass.getMethod("getBalance");
        String accountNumber = (String) getAccountNumberMethod.invoke(account);
        double balance = (double) getBalanceMethod.invoke(account);

        // Verify that the accountNumber and balance are correctly set
        assertEquals("111222333", accountNumber);
        assertEquals(1000.0, balance);
    }
}
