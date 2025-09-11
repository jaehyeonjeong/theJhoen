package exception05.exception;

public class NetworkClientException0501 extends Exception{

    public NetworkClientException0501(String message) {
        // super는 항상 최상단
        super(message);
    }

    // Exception도 클래스 이다.
}
