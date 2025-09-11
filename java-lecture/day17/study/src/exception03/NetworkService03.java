package exception03;

public class NetworkService03 {
    public void sendMessage(String data) {
        String address = "http://www.myserver.com";
        // 클라이언트 객체 생성
        NetworkClient03 client02 = new NetworkClient03(address);
        // 오류 상황 재현
//        client02.initError("error02");
        client02.initError("error01");
        // 클라이언트 연결
        client02.connect();
        // 데이터 전송
        client02.send(data);
        // 클라이언트 연결 해제
        client02.disconnect();
    }
}
