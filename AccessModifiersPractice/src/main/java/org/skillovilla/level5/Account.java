package org.skillovilla.level5;

public class Account {
    public String accountNumber;
    private double balance;
    protected String accountType;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    void deposit(double amount){
        setBalance(getBalance() + amount);
    }

    void withdraw(double amount){
        setBalance(getBalance() - amount);
    }
}
