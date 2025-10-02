package exception04;

public class NetworkService04 {
    // 예외처리를 못하겠으면 서버단에서 예외처리 호출
    public void sendMessage(String data) throws NetworkClientException04 {
        String address = "http://www.myserver.com";
        // 클라이언트 객체 생성
        NetworkClient04 client04 = new NetworkClient04(address);
        // 오류 상황 재현
//        client04.initError("error02");
        client04.initError("error01");
        // 클라이언트 연결
        client04.connect();
        // 데이터 전송
        client04.send(data);
        // 클라이언트 연결 해제
        client04.disconnect();
    }
}
