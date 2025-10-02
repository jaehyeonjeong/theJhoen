package exception06;

import exception06.exception.ConnectionException06;
import exception06.exception.SendException06;

public class NetworkService0601 {
    // 예외처리를 못하겠으면 서버단에서 예외처리 호출
    public void sendMessage(String data) throws Exception {
        String address = "http://www.myserver.com";

        // try 안에 쓸 자원을 항상 명시
        try(NetworkClient0601 client06 = new NetworkClient0601(address)){
            client06.initError(data);
            client06.connect();
            client06.send(data);
        } catch (ConnectionException06 e) {
            System.out.println("[예외 확인] : " + e.getMessage() + ", 주소 : " + e.getAddress());
            throw e;
        } catch (SendException06 e) {
            System.out.println("[예외 확인] : " + e.getMessage() + ", 데이터 : " + e.getSendDate());
            throw e;
        } catch (Exception e) {
            System.out.println("[예외 확인] : " + e.getMessage());
            throw e;
        }

    }
}
