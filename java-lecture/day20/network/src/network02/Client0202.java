package network02;

import utils.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static utils.MyLogger.log;

public class Client0202 {
    private static final int PORT = 12345;
    // 자원 회수를 하는 방법 도모

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        log("소켓 연결 : "+socket);

        try {
            socket = new Socket("localhost",PORT);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("전송할 문자 : ");
                String toSend = scanner.nextLine();
                dataOutputStream.writeUTF(toSend);
                log("client ===>  server : "+toSend);
                if(toSend.equals("exit")) break;
                String received = dataInputStream.readUTF();
                log("clinet  <=== server : "+received);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            SocketCloseUtil.closeAll(socket, dataInputStream, dataOutputStream);
            log("연결 종료 : " + socket);
        }
    }
}
