package exception0401;

public class NetworkClient0401 {
    // 주소
    private final String address;
    // 연결 오류
    public boolean connectError;
    // 전송 오류
    public boolean sendError;
    // 생성자 주입
    public NetworkClient0401(String address) {
        this.address = address;
    }

    public void connect() throws NetworkClientException0401 {
        // 연결 실패
        if(connectError) {
            throw new NetworkClientException0401("connect Error", address + " 서버 연결 실패");
        }
        System.out.println(address + "서버 연결 성공");
    }

    public void send(String data) throws NetworkClientException0401 {
        // 데이터 전송 실패
        if (sendError) {
            // 뭔가 잘못되면 예외를 던지고 있음.
            throw new NetworkClientException0401("send Error", address + " 서버에 데이터 전송 실패" + data);
        }
        System.out.println(address + "서버에 데이터 전송 : " + data);
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

    public void initError(String data) {
        if(data.contains("error01")) {
            connectError = true;
        }
        if(data.contains("error02")) {
            sendError = true;
        }
    }
}
