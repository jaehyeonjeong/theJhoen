package exception0401;

public class NetworkClientException0401 extends Exception{
    private String errorCode;

    public NetworkClientException0401(String errorCode, String message) {
        // super는 항상 최상단
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
