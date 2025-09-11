package network01;

import javax.net.ssl.SSLSession;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static utils.MyLogger.log;

public class Server02 {
    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트 : "+PORT);
        while(true) {
            Socket socket = serverSocket.accept();
            log("소켓 연결 : "+socket);
            Session03 session03 = new Session03(socket);
            Thread thread = new Thread(session03);
            thread.start();
        }
    }
}
