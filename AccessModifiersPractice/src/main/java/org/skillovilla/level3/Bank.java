package org.skillovilla.level3;

public class Bank{

    public void accessAccount(String accountNumber, double balance) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
    }
}
