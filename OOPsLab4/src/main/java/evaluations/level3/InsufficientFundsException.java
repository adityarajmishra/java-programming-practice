package evaluations.level3;

public class InsufficientFundsException extends Exception {
    private String exceptionResolutionAlgorithm;

    public InsufficientFundsException(String message, String exceptionResolutionAlgorithm) {
        super(message);
        this.exceptionResolutionAlgorithm = exceptionResolutionAlgorithm;
    }
    public String getExceptionResolutionAlgorithm() {
        return exceptionResolutionAlgorithm;
    }
}
