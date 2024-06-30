package evaluations.level10;

public class InsufficientFundsException extends RuntimeException{
    private final double balance;

    public InsufficientFundsException(double balance, String message) {
        super(message);
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getSuggestion() {
        return "Insufficient funds.";
    }

}
