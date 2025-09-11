package network02;

import utils.SocketCloseUtil;

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
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        // 데이터 인풋 아웃풋
        try {
            while(true) {
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String received = dataInputStream.readUTF();
                log("client ===> server : " +received );
                if(received.equals("exit")) break;
                String toSend = received + " World!!";
                dataOutputStream.writeUTF(toSend);
                log("client <=== server : " +toSend);
            }

        } catch (IOException e) {
            log(e);
        } finally {
            System.out.println("연결 종료 : " + socket);
            SocketCloseUtil.closeAll(socket, dataInputStream, dataOutputStream);
        }
    }
}
