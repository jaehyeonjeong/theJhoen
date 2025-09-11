package exception0401;

public class NetworkService0401 {
    // 예외처리를 못하겠으면 서버단에서 예외처리 호출
    public void sendMessage(String data) {
        String address = "http://www.myserver.com";
        // 클라이언트 객체 생성
        NetworkClient0401 client04 = new NetworkClient0401(address);
        // 오류 상황 재현
//        client04.initError("error02");
        client04.initError("error01");
        // 클라이언트 연결
        try {
            client04.connect();
        } catch (NetworkClientException0401 e) {
            System.out.println("오류 코드 : " + e.getErrorCode() + ", 메세지 : " + e.getMessage());
            return;
        }
        // 데이터 전송
        try {
            client04.send(data);
        } catch (NetworkClientException0401 e) {
            System.out.println("오류 코드 : " + e.getErrorCode() + ", 메세지 : " + e.getMessage());
            return;
        }
        // 클라이언트 연결 해제
        client04.disconnect();
    }
}
