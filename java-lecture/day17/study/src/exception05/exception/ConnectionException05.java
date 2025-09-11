package exception05.exception;

public class ConnectionException05 extends NetworkClientException0501 {
    private final String address;

    public ConnectionException05(String message, String address) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
