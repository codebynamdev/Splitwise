package exceptions;

public class InvalidExpenseException extends RuntimeException {
    public InvalidExpenseException(String msg) {
        super(msg);
    }
}
