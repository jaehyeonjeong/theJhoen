package basic.checked;

public class Client {
    public void call() throws MyCheckedException {
        throw new MyCheckedException("exception"); // 예외 발생
    }
}
