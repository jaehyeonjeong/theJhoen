package exception06.exception;

public class NetworkClientException06 extends RuntimeException{

    public NetworkClientException06(String message) {
        // super는 항상 최상단
        super(message);
    }

    // Exception도 클래스 이다.
}
