package exception03;

public class NetworkService0301 {
    public void sendMessage(String data) {
        String address = "http://www.myserver.com";
        // 클라이언트 객체 생성
        NetworkClient03 client02 = new NetworkClient03(address);
        // 오류 상황 재현
        client02.initError("error02");
//        client02.initError("error01");
        // 클라이언트 연결
        String connect = client02.connect();
        if(!connect.equals("connect Success")){
            System.out.println("네트워크 오류 발생 오류 코드 : " + connect);
            return;
        }
        System.out.println(connect);
        // 데이터 전송
        String send = client02.send(data);
        if(!send.equals("send Success")) {
            System.out.println("네트워크 오류 발생 오류 코드 : " + send);
            return;
        }
        System.out.println(send);
        // 클라이언트 연결 해제
        client02.disconnect();
    }
}
