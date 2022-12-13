package exception;

public class InvalidComponentException extends Exception {
    public InvalidComponentException(String message){
        super(String.valueOf(message));
    }
}
