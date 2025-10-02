package network01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static utils.MyLogger.log;

public class Client0202 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("localhost",PORT);

        // 메모리가 계속 살아있는 상태
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        log("소켓 연결 : "+socket);

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

        //서버에서 넘어오 데이터 받기

        dataInputStream.close();
        dataOutputStream.close();
        socket.close();

    }
}
