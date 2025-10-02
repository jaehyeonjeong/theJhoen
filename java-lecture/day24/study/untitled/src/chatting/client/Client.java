package chatting.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

public class Client {
    private final String host;      // IP
    private final int port;         // Port
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    private ReadHandler readHandler;
    private WriteHandler writeHandler;
    private boolean closed = false;

    // final로 선언된 변수는 생성자를 사용하거나 미리 선언해야한다.
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        log("클라이언트 시작");
        socket = new Socket(host, port);

        // DataStream은 보조, 진짜는 socket의 바이트 데이터를 스트림으로 전환
        input = new DataInputStream(socket.getInputStream());       // byte로 통신하는 것을 스트림으로 편리하게 사용
        output = new DataOutputStream(socket.getOutputStream());
        // read write 핸들러 객체 선언
        readHandler = new ReadHandler(input, this); // 자신이 클라이언트이기 때문에 this를 넣어줌
        writeHandler = new WriteHandler(output, this); // 자신이 클라이언트이기 때문에 this를 넣어줌

        // 시작과 동시에 스레드 시작
        activateThread();
    }

    private void activateThread() {
        // 2개의 핸들러를 갖는 스레도 동작
        Thread readThread = new Thread(readHandler, "readHandler"); // Thread 파라미터에는 Runnable
        Thread writeThread = new Thread(writeHandler, "writeHandler"); // Thread 파라미터에는 Runnable
        readThread.start();
        writeThread.start();
    }

    public synchronized void close() {
        if(closed) return;
        readHandler.close();
        writeHandler.close();
        closed = true;
        log("client 연결 종료 : " + socket);
    }
}