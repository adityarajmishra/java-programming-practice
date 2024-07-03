package org.skillovilla.level2;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testWithdrawValid() throws Exception {
        // Test valid withdrawal
        Class<?> bankAccountClass = Class.forName("org.skillovilla.level2.BankAccount");
        Object account = bankAccountClass.getDeclaredConstructor(String.class, double.class)
                                         .newInstance("12345", 1000);

        Method withdrawMethod = bankAccountClass.getMethod("withdraw", double.class);
        Method getBalanceMethod = bankAccountClass.getMethod("getBalance");

        assertDoesNotThrow(() -> withdrawMethod.invoke(account, 500));
        double balance = (double) getBalanceMethod.invoke(account);
        assertEquals(500, balance);
    }

    @Test
    void testWithdrawInvalid() throws Exception {
        // Test invalid withdrawal
        Class<?> bankAccountClass = Class.forName("org.skillovilla.level2.BankAccount");
        Object account = bankAccountClass.getDeclaredConstructor(String.class, double.class)
                                         .newInstance("12345", 1000);

        Method withdrawMethod = bankAccountClass.getMethod("withdraw", double.class);

        assertThrows(Exception.class, () -> {
            try {
                withdrawMethod.invoke(account, 1500);
            } catch (Exception e) {
                if (e.getCause() != null && e.getCause().getClass().getName().equals("org.skillovilla.level2.InvalidTransactionException")) {
                    throw (Exception) e.getCause();
                }
                throw e;
            }
        });
    }

    @Test
    void testDepositValid() throws Exception {
        // Test valid deposit
        Class<?> bankAccountClass = Class.forName("org.skillovilla.level2.BankAccount");
        Object account = bankAccountClass.getDeclaredConstructor(String.class, double.class)
                                         .newInstance("12345", 1000);

        Method depositMethod = bankAccountClass.getMethod("deposit", double.class);
        Method getBalanceMethod = bankAccountClass.getMethod("getBalance");

        assertDoesNotThrow(() -> depositMethod.invoke(account, 500));
        double balance = (double) getBalanceMethod.invoke(account);
        assertEquals(1500, balance);
    }

    @Test
    void testDepositInvalid() throws Exception {
        // Test invalid deposit
        Class<?> bankAccountClass = Class.forName("org.skillovilla.level2.BankAccount");
        Object account = bankAccountClass.getDeclaredConstructor(String.class, double.class)
                                         .newInstance("12345", 1000);

        Method depositMethod = bankAccountClass.getMethod("deposit", double.class);

        assertThrows(Exception.class, () -> {
            try {
                depositMethod.invoke(account, -500);
            } catch (Exception e) {
                if (e.getCause() != null && e.getCause().getClass().getName().equals("org.skillovilla.level2.InvalidTransactionException")) {
                    throw (Exception) e.getCause();
                }
                throw e;
            }
        });
    }
}
