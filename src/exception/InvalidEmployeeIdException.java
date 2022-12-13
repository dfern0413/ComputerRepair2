package exception;

public class InvalidEmployeeIdException extends Exception{
    public InvalidEmployeeIdException(String message){
        super(String.valueOf(message));
    }
}
