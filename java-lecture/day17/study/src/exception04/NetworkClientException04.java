package exception04;

public class NetworkClientException04 extends Exception{
    private String errorCode;

    public NetworkClientException04(String errorCode, String message) {
        // super는 항상 최상단
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
