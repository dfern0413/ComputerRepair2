package exception;

public class InvalidEmployeeSelectedException extends Exception{
    public InvalidEmployeeSelectedException(String message){
        super(String.valueOf(message));
    }
}
