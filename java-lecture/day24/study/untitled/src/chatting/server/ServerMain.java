package chatting.server;

import java.io.IOException;

public class ServerMain {
    private static final int PORT = 12345;      // 상수는 대문자
    public static void main(String[] args) throws IOException {
        Server server = new Server(PORT);
        server.start();
    }
}
