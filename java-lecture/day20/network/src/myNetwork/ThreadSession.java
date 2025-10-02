package myNetwork;

import myNetwork.utils.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static myNetwork.utils.Logger.log;

// 서버에 다중으로 클라이언트가 전송할 데이터를 보내기 위한 스레드 생성
// 스레드 인스턴스 중 Runnable을 사용
public class ThreadSession implements Runnable{
    private final Socket socket;

    // 생성자 주입 방식으로 생성이 필요
    public ThreadSession(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 데이터 인풋 아웃풋 변수를 넣어서 적용
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            while(true) {
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // 클라이언트에서 적힌 글을 읽어야 하고 어떤 클라이언트에서 보냈는지 확인이 필요
                String received = dataInputStream.readUTF();
                log("client(" + socket.getPort() + ") ===> server : " + received);
//                ThreadTextSession.textOutput(received, socket);
                // 만약 exit 문구를 받으면 종료
                if(received.equals("exit")) break;

                String toSend = received + socket.getPort();
                dataOutputStream.writeUTF(toSend);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            System.out.println("연결 종료 : " + socket);
            SocketCloseUtil.closeAll(socket, dataInputStream, dataOutputStream);
        }
    }
}
