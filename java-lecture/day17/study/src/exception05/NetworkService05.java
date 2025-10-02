package exception05;

import exception05.exception.ConnectionException05;
import exception05.exception.NetworkClientException0501;
import exception05.exception.SendException05;

public class NetworkService05 {
    // 예외처리를 못하겠으면 서버단에서 예외처리 호출
    public void sendMessage(String data) throws ConnectionException05, SendException05 {
        String address = "http://www.myserver.com";
        // 클라이언트 객체 생성
        NetworkClient05 client04 = new NetworkClient05(address);
        // 오류 상황 재현
        client04.initError("error02");
//        client04.initError("error01");
        try {
            // 클라이언트 연결
            client04.connect();
            // 데이터 전송
            client04.send(data);
        }catch (ConnectionException05 | SendException05 e) {
            System.out.println("[연결 오류] 메세지 : " + e.getMessage());
        }catch (NetworkClientException0501 e) {
            System.out.println("[네트웤에 알수 없는] 메세지 : " + e.getMessage());
        }catch (Exception e) {
            System.out.println("[알 수 없는 오류] 메세지 : " + e.getMessage());
        }finally {
            // 클라이언트 연결 해제
            client04.disconnect();
        }

    }
}
