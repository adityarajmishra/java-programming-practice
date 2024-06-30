package evaluations.level3;

public class InvalidAccountException extends RuntimeException {
    private long exceptionResolutionId;
    public InvalidAccountException(String message,
                                   long exceptionResolutionId) {
        super(message);
        this.exceptionResolutionId = exceptionResolutionId;
    }

    public long getExceptionResolutionId() {
        return exceptionResolutionId;
    }
}
