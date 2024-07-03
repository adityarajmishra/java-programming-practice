package org.skillovilla.level3;

public class InsufficientFundsException extends BankOperationException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
