package basic.unchecked;

public class MyUnCheckedException extends RuntimeException{
    // Checked Exception : extends Exception

    public MyUnCheckedException(String message) {
        super(message);
    }
}
