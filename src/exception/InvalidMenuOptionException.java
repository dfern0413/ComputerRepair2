package exception;

public class InvalidMenuOptionException extends Exception{
    public InvalidMenuOptionException(String message){
        super(String.valueOf(message));
    }
}
