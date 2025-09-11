package exception0401;

public class NetworkService0402 {
    // 예외처리를 못하겠으면 서버단에서 예외처리 호출
    public void sendMessage(String data) {
        String address = "http://www.myserver.com";
        // 클라이언트 객체 생성
        NetworkClient0401 client04 = new NetworkClient0401(address);
        // 오류 상황 재현
        client04.initError("error02");
//        client04.initError("error01");
        // 모든걸 조건문으로 처리하면 안됨. 코드가 망가짐
        // 클라이언트 연결
        try {
            client04.connect();
            client04.send(data);
        } catch (NetworkClientException0401 e) {
            System.out.println("오류 코드 : " + e.getErrorCode() + ", 메세지 : " + e.getMessage());
        } finally {
            // 오류가 나더라도 무조건 실행한다.
            client04.disconnect();
        }
    }
}
