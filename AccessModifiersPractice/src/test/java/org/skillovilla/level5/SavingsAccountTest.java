package org.skillovilla.level5;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

//public class SavingsAccountTest {
//
//    @Test
//    public void testApplyInterest() throws Exception {
//        // Access the SavingsAccount class
//        Class<?> savingsAccountClass = Class.forName("org.skillovilla.level5.SavingsAccount");
//        Object savingsAccount = savingsAccountClass.getDeclaredConstructor().newInstance();
//
//        // Set account number
//        Method setAccountNumberMethod = savingsAccountClass.getMethod("setAccountNumber", String.class);
//        setAccountNumberMethod.invoke(savingsAccount, "111222333");
//
//        // Set balance
//        Method setBalanceMethod = savingsAccountClass.getMethod("setBalance", double.class);
//        setBalanceMethod.invoke(savingsAccount, 1000.0);
//
//        // Set account type
//        Method setAccountTypeMethod = savingsAccountClass.getMethod("setAccountType", String.class);
//        setAccountTypeMethod.invoke(savingsAccount, "Savings");
//
//        // Apply interest
//        Method applyInterestMethod = savingsAccountClass.getDeclaredMethod("applyInterest", double.class);
//        applyInterestMethod.setAccessible(true);
//        applyInterestMethod.invoke(savingsAccount, 5.0);
//
//        // Get balance
//        Method getBalanceMethod = savingsAccountClass.getMethod("getBalance");
//        double balance = (double) getBalanceMethod.invoke(savingsAccount);
//        assertEquals(1050.0, balance);
//    }
//
//    @Test
//    public void testDeposit() throws Exception {
//        // Access the Account class (since deposit method is defined in Account class)
//        Class<?> accountClass = Class.forName("org.skillovilla.level5.Account");
//        Object account = accountClass.getDeclaredConstructor().newInstance();
//
//        // Set balance
//        Method setBalanceMethod = accountClass.getMethod("setBalance", double.class);
//        setBalanceMethod.invoke(account, 1000.0);
//
//        // Access and invoke deposit method
//        Method depositMethod = accountClass.getDeclaredMethod("deposit", double.class);
//        depositMethod.setAccessible(true);
//        depositMethod.invoke(account, 500.0);
//
//        // Get balance
//        Method getBalanceMethod = accountClass.getMethod("getBalance");
//        double balance = (double) getBalanceMethod.invoke(account);
//        assertEquals(1500.0, balance);
//    }
//
//    @Test
//    public void testWithdraw() throws Exception {
//        // Access the Account class (since withdraw method is defined in Account class)
//        Class<?> accountClass = Class.forName("org.skillovilla.level5.Account");
//        Object account = accountClass.getDeclaredConstructor().newInstance();
//
//        // Set balance
//        Method setBalanceMethod = accountClass.getMethod("setBalance", double.class);
//        setBalanceMethod.invoke(account, 1000.0);
//
//        // Access and invoke withdraw method
//        Method withdrawMethod = accountClass.getDeclaredMethod("withdraw", double.class);
//        withdrawMethod.setAccessible(true);
//        withdrawMethod.invoke(account, 300.0);
//
//        // Get balance
//        Method getBalanceMethod = accountClass.getMethod("getBalance");
//        double balance = (double) getBalanceMethod.invoke(account);
//        assertEquals(700.0, balance);
//    }
//}
public class SavingsAccountTest {

    @Test
    public void testApplyInterest() throws Exception {
        // Access the SavingsAccount class
        Class<?> savingsAccountClass = Class.forName("org.skillovilla.level5.SavingsAccount");
        Object savingsAccount = savingsAccountClass.getDeclaredConstructor().newInstance();

        // Set account number
        Method setAccountNumberMethod = savingsAccountClass.getMethod("setAccountNumber", String.class);
        setAccountNumberMethod.invoke(savingsAccount, "111222333");

        // Set balance
        Method setBalanceMethod = savingsAccountClass.getMethod("setBalance", double.class);
        setBalanceMethod.invoke(savingsAccount, 1000.0);

        // Set account type
        Method setAccountTypeMethod = savingsAccountClass.getMethod("setAccountType", String.class);
        setAccountTypeMethod.invoke(savingsAccount, "Savings");

        // Apply interest
        Method applyInterestMethod = savingsAccountClass.getDeclaredMethod("applyInterest");
        applyInterestMethod.setAccessible(true);
        applyInterestMethod.invoke(savingsAccount);

        // Get balance
        Method getBalanceMethod = savingsAccountClass.getMethod("getBalance");
        double balance = (double) getBalanceMethod.invoke(savingsAccount);
        assertEquals(1050.0, balance); // 1000 + 5% interest
    }

    @Test
    public void testDeposit() throws Exception {
        // Access the Account class (since deposit method is defined in Account class)
        Class<?> accountClass = Class.forName("org.skillovilla.level5.Account");
        Object account = accountClass.getDeclaredConstructor().newInstance();

        // Set balance
        Method setBalanceMethod = accountClass.getMethod("setBalance", double.class);
        setBalanceMethod.invoke(account, 1000.0);

        // Access and invoke deposit method
        Method depositMethod = accountClass.getDeclaredMethod("deposit", double.class);
        depositMethod.setAccessible(true);
        depositMethod.invoke(account, 500.0);

        // Get balance
        Method getBalanceMethod = accountClass.getMethod("getBalance");
        double balance = (double) getBalanceMethod.invoke(account);
        assertEquals(1500.0, balance);
    }

    @Test
    public void testWithdraw() throws Exception {
        // Access the Account class (since withdraw method is defined in Account class)
        Class<?> accountClass = Class.forName("org.skillovilla.level5.Account");
        Object account = accountClass.getDeclaredConstructor().newInstance();

        // Set balance
        Method setBalanceMethod = accountClass.getMethod("setBalance", double.class);
        setBalanceMethod.invoke(account, 1000.0);

        // Access and invoke withdraw method
        Method withdrawMethod = accountClass.getDeclaredMethod("withdraw", double.class);
        withdrawMethod.setAccessible(true);
        withdrawMethod.invoke(account, 300.0);

        // Get balance
        Method getBalanceMethod = accountClass.getMethod("getBalance");
        double balance = (double) getBalanceMethod.invoke(account);
        assertEquals(700.0, balance);
    }
}
