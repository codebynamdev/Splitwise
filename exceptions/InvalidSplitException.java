package exceptions;

public class InvalidSplitException extends RuntimeException{
    public InvalidSplitException(String msg) {
        super(msg);
    }
}