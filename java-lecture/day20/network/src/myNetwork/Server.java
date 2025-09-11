package myNetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static myNetwork.utils.Logger.log;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");

        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트 : " + PORT);

        while(true) {
            // 반복문 안에 socket을 accept 해야지만 다른 클라이언트 소켓을 받을 수 있음
            Socket socket = serverSocket.accept();
            log("소켓 연결 : " + socket);
            // 만들어진 세션으로 지원 받는 스레드로 동작
            ThreadSession threadSession = new ThreadSession(socket);
            Thread thread = new Thread(threadSession);
            thread.start();
        }
    }
}
