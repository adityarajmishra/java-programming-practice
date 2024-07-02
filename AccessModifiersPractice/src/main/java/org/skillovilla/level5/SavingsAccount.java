package org.skillovilla.level5;

public class SavingsAccount extends Account{
    void applyInterest(){
        double interest = getBalance() * 0.05;
        setBalance(getBalance() + interest);
    }
}
