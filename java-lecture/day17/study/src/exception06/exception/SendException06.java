package exception06.exception;

public class SendException06 extends NetworkClientException06 {
    private final String sendDate;

    public SendException06(String message, String sendDate) {
        super(message);
        this.sendDate = sendDate;
    }

    public String getSendDate() {
        return sendDate;
    }
}
