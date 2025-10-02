package exception06;

import exception06.exception.ConnectionException06;
import exception06.exception.NetworkClientException06;
import exception06.exception.SendException06;

public class NetworkService06 {
    // 예외처리를 못하겠으면 서버단에서 예외처리 호출
    public void sendMessage(String data) {
        String address = "http://www.myserver.com";
        // 클라이언트 객체 생성
//        NetworkClient06 client06 = new NetworkClient06(address);
        // 오류 상황 재현
//        client06.initError("error02");
//        client06.initError("error01");
//        client06.initError(data);
//        try {
//            // 클라이언트 연결
//            client06.connect();
//            // 데이터 전송
//            client06.send(data);
////        }catch (ConnectionException06 | SendException06 e) {
////            System.out.println("[연결 오류] 메세지 : " + e.getMessage());
//        }catch (ConnectionException06 e) {
//            System.out.println("[연결 오류] 에러코드 : " + e.getMessage() + " 주소 : " + e.getAddress());
//        } catch (SendException06 e) {
//            System.out.println("[메세지 전송 오류] 에러코드 : " + e.getMessage() + " 데이터 : " + e.getSendDate());
//        }catch (NetworkClientException06 e) {
//            System.out.println("[네트웤에 알수 없는] 에러코드 : " + e.getMessage());
//        }catch (Exception e) {
//            System.out.println("[알 수 없는 오류] 메세지 : " + e.getMessage());
//        }finally {
//            // 클라이언트 연결 해제
//            client06.disconnect();
//        }
        NetworkClient06 client06 =
                new NetworkClient06(address);
        client06.initError(data);
        try{
            client06.connect();
            client06.send(data);
        }  finally {
            client06.disconnect();
        }

    }
}
