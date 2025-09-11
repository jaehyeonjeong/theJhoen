package exception05;

import exception04.NetworkClientException04;
import exception05.exception.ConnectionException05;
import exception05.exception.NetworkClientException0501;
import exception05.exception.SendException05;

public class NetworkClient05 {
    // 주소
    private final String address;
    // 연결 오류
    public boolean connectError;
    // 전송 오류
    public boolean sendError;
    // 생성자 주입
    public NetworkClient05(String address) {
        this.address = address;
    }

    public void connect() throws ConnectionException05 {
        // 연결 실패
        if(connectError) {
            throw new ConnectionException05("connect Error", address + " 서버 연결 실패");
        }
        System.out.println(address + "서버 연결 성공");
    }

    public void send(String data) throws SendException05 {
        // 데이터 전송 실패
        if (sendError) {
            // 뭔가 잘못되면 예외를 던지고 있음.
            throw new SendException05("send Error", address + " 서버에 데이터 전송 실패" + data);
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
