public class IllegalTransactionException extends RuntimeException{
	
	public IllegalTransactionException() {
        super("Transaction declined.");
    }
	public IllegalTransactionException(String message) {
        super("Transaction declined: " + message);
    }
}
