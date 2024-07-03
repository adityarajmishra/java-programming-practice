package org.skillovilla.level3;

import org.junit.jupiter.api.Test;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void testWithdrawValid() throws Exception {
        // Test valid withdrawal
        Class<?> bankAccountClass = Class.forName("org.skillovilla.level3.BankAccount");
        Object account = bankAccountClass.getDeclaredConstructor(String.class, double.class, String.class)
                .newInstance("12345", 1000, "Alice");

        Method withdrawMethod = bankAccountClass.getMethod("withdraw", double.class, String.class);
        Method getBalanceMethod = bankAccountClass.getMethod("getBalance");

        assertDoesNotThrow(() -> withdrawMethod.invoke(account, 500, "Alice"));
        double balance = (double) getBalanceMethod.invoke(account);
        assertEquals(500, balance);
    }

    @Test
    void testWithdrawUnauthorizedAccess() throws Exception {
        // Test invalid withdrawal due to unauthorized access
        Class<?> bankAccountClass = Class.forName("org.skillovilla.level3.BankAccount");
        Object account = bankAccountClass.getDeclaredConstructor(String.class, double.class, String.class)
                .newInstance("12345", 1000, "Alice");

        Method withdrawMethod = bankAccountClass.getMethod("withdraw", double.class, String.class);
        Class<?> unauthorizedAccessExceptionClass = Class.forName("org.skillovilla.level3.UnauthorizedAccessException");

        assertThrows(Exception.class, () -> {
            try {
                withdrawMethod.invoke(account, 500, "Bob");
            } catch (Exception e) {
                if (e.getCause() != null && unauthorizedAccessExceptionClass.isInstance(e.getCause())) {
                    throw (Exception) e.getCause();
                }
                throw e;
            }
        });
    }

    @Test
    void testWithdrawInsufficientFunds() throws Exception {
        // Test invalid withdrawal due to insufficient funds
        Class<?> bankAccountClass = Class.forName("org.skillovilla.level3.BankAccount");
        Object account = bankAccountClass.getDeclaredConstructor(String.class, double.class, String.class)
                .newInstance("12345", 1000, "Alice");

        Method withdrawMethod = bankAccountClass.getMethod("withdraw", double.class, String.class);
        Class<?> insufficientFundsExceptionClass = Class.forName("org.skillovilla.level3.InsufficientFundsException");

        assertThrows(Exception.class, () -> {
            try {
                withdrawMethod.invoke(account, 1500, "Alice");
            } catch (Exception e) {
                if (e.getCause() != null && insufficientFundsExceptionClass.isInstance(e.getCause())) {
                    throw (Exception) e.getCause();
                }
                throw e;
            }
        });
    }

    @Test
    void testDepositValid() throws Exception {
        // Test valid deposit
        Class<?> bankAccountClass = Class.forName("org.skillovilla.level3.BankAccount");
        Object account = bankAccountClass.getDeclaredConstructor(String.class, double.class, String.class)
                .newInstance("12345", 1000, "Alice");

        Method depositMethod = bankAccountClass.getMethod("deposit", double.class);
        Method getBalanceMethod = bankAccountClass.getMethod("getBalance");

        assertDoesNotThrow(() -> depositMethod.invoke(account, 500));
        double balance = (double) getBalanceMethod.invoke(account);
        assertEquals(1500, balance);
    }

    @Test
    void testDepositInvalid() throws Exception {
        // Test invalid deposit
        Class<?> bankAccountClass = Class.forName("org.skillovilla.level3.BankAccount");
        Object account = bankAccountClass.getDeclaredConstructor(String.class, double.class, String.class)
                .newInstance("12345", 1000, "Alice");

        Method depositMethod = bankAccountClass.getMethod("deposit", double.class);
        Class<?> bankOperationExceptionClass = Class.forName("org.skillovilla.level3.BankOperationException");

        assertThrows(Exception.class, () -> {
            try {
                depositMethod.invoke(account, -500);
            } catch (Exception e) {
                if (e.getCause() != null && bankOperationExceptionClass.isInstance(e.getCause())) {
                    throw (Exception) e.getCause();
                }
                throw e;
            }
        });
    }
}
