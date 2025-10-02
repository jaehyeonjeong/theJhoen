package exception05.exception;

public class SendException05 extends NetworkClientException0501 {
    private final String sendDate;

    public SendException05(String message, String sendDate) {
        super(message);
        this.sendDate = sendDate;
    }

    public String getSendDate() {
        return sendDate;
    }
}
