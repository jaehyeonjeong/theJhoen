package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static utils.MyLogger.log;

public class Client01 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("127.0.0.1", PORT);  // 로컬 서버의 ip : 127.0.0.1 = localhost

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        log("소켓 연결 : " + socket);

        String toSend = "Hello";
        dataOutputStream.writeUTF(toSend);
        log("client(write) ===> server : " + toSend);

        // 서버에서 넘어온 데이터 받기
        String received = dataInputStream.readUTF();
        log("server(Read) ===> client : " + received);

        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
    }
}
