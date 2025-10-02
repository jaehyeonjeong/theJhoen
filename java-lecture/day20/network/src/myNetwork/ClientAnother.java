package myNetwork;

import myNetwork.utils.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static myNetwork.utils.Logger.log;

public class ClientAnother {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        log("클라이언트 시작");
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            socket = new Socket("localhost", PORT);
            log("소켓 연결 : " + socket);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            while(true) {
                System.out.println("전송할 문자 : " );
                String toSend = scanner.nextLine();
                // 클라이언트가 서버에 보낼 데이터
                dataOutputStream.writeUTF(toSend);
                log("client ===> server : " + toSend);
                if(toSend.equals("exit")) break;
                // 서버로 부터 받은 데이터
                String received = dataInputStream.readUTF();
                log("server ===> client : " + received);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            SocketCloseUtil.closeAll(socket, dataInputStream, dataOutputStream);
            log("연결 종료 : " + socket);
        }
    }
}
