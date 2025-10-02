package network03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static utils.MyLogger.log;

public class Server03 {
    private static final int PORT = 12345;
    public static void main(String[] args) throws IOException {
        log("서버 시작");
        // 서버는 항상 서버 소켓을 가지고 포트를 명확히 지정해준다.
        ServerSocket serverSocket = new ServerSocket(PORT);
        // 서버로 클라이언트가 접속을 시도
        log("서버 소켓 시작 - 리스닝 포트 : " + PORT);
        Socket socket = serverSocket.accept();      // 접속 시도
        // accept 를 통애서 소켓을 생성
        log("소켓 연결 : " + socket);
        // 데이터 보낸 거를 출력 : I/O이 필요
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        while(true) {
            String received = dataInputStream.readUTF();
            log("client(Read) ===> server : " + received);

            String toSend = received + " World!!!";
            dataOutputStream.writeUTF(toSend);
            log("server ===> client : " + toSend);

            if(received.equals("그만")) {
                break;
            }
        }
    }
}
