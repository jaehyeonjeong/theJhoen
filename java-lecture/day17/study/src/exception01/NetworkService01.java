package exception01;

public class NetworkService01 {
    public void sendMessage(String data) {
        String address = "http://www.myserver.com";
        // 클라이언트 객체 생성
        NetworkClient01 client01 = new NetworkClient01(address);
        // 클라이언트 연결
        client01.connect();
        // 데이터 전송
        client01.send(data);
        // 클라이언트 연결 해제
        client01.disconnect();
    }
}
