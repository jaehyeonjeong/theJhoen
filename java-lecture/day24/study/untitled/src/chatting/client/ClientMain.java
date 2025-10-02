package chatting.client;

import java.io.IOException;

public class ClientMain {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", PORT);
        client.start();
    }
    // 커멘드 패턴 (command pattern) : 디자인 패턴 중 하나, 자바 코드 common
}
