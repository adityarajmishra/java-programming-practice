package org.skillovilla.level3;

public class UnauthorizedAccessException extends BankOperationException {
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
