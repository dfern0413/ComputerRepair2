package exception;

public class InvalidMenuOption extends Exception{
    public InvalidMenuOption(String message){
        super(String.valueOf(message));
    }
}
