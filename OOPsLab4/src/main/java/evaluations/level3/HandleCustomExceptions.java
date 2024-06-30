package evaluations.level3;

public class HandleCustomExceptions {

    public void invalidAccountException(String message, int exceptionResolutionId) {
        throw new InvalidAccountException(message, exceptionResolutionId);
    }

    public void insufficientFundsException(String message, String exceptionResolutionAlgorithm) throws InsufficientFundsException {
        throw new InsufficientFundsException(message, exceptionResolutionAlgorithm);
    }



}
