package basic.unchecked;

public class Client {
    public void call() {
        // unchecked는 예외를 던지지 않아도 된다.
        throw new MyUnCheckedException("unchecked exception");
    }
}
