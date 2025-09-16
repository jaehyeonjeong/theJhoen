package chatting.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static utils.MyLogger.log;

public class Server {
    private final int port;
    private ServerSocket serverSocket;

    // client가 여러개 들어올 수 있다. client Session / SessionManager
    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        log("서버 시작 : ");
        serverSocket = new ServerSocket(port);
        log("서버소켓 시작 - 리스닝 포트 : " + port);
        running();
    }

    private void running() {
        // session 문제를 해결하기 위한 코드
        try {
            while(true) {
                Socket socket = serverSocket.accept();
                log("소켓 연결 : " + socket);
                Session session = new Session(socket);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            log(e);
        }

    }
}
