package network01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static utils.MyLogger.log;

// 쓰레드로 만들어야 함.
public class Session03 implements Runnable{
    private final Socket socket;

    // 생성자 주입 방식
    public Session03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 데이터 인풋 아웃풋
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while(true) {
                String received = dataInputStream.readUTF();
                log("client ===> server : " +received );
                if(received.equals("exit")) break;
                String toSend = received + " World!!";
                dataOutputStream.writeUTF(toSend);
                log("client <=== server : " +toSend);
            }
            System.out.println("연결 종료 : " + socket);
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
