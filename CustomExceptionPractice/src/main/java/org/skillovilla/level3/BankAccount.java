package org.skillovilla.level3;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private String owner;

    public BankAccount(String accountNumber, double balance, String owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public void withdraw(double amount, String requester) throws UnauthorizedAccessException, InsufficientFundsException {
        if (!requester.equals(owner)) {
            throw new UnauthorizedAccessException("Unauthorized access");
        }
        if (balance - amount < 0 || amount <= 0 ) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
    }

    public void deposit(double amount) throws BankOperationException {
        if (amount <= 0) {
            throw new BankOperationException("Invalid amount");
        }
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
