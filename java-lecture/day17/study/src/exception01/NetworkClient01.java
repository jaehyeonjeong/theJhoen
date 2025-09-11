package exception01;

public class NetworkClient01 {
    // 주소
    private final String address;
    // 생성자 주입
    public NetworkClient01(String address) {
        this.address = address;
    }

    public void connect() {
        // 연결 성공
        System.out.println(address + " 서버 연결 성공");
    }

    public String send(String data) {
        System.out.println(address + " 서버에 데이터 전송 : " + data);
        return "success";
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }
}
