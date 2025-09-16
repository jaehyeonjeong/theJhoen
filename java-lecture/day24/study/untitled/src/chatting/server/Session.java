package chatting.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import static utils.MyLogger.log;

// 세션을 만들어야 에러가 생기지 않음.
public class Session implements Runnable {
    private final Socket socket;
    private  DataInputStream input;
    private  DataOutputStream output;

    private boolean closed = false;
    private String username;

    public Session(Socket socket, DataInputStream input, DataOutputStream output) {
        this.socket = socket;
        this.input = input;
        this.output = output;
    }

    public Session(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }

    public void close() {
        if(closed) return;
        closed = true;
        log("연결 종료 : " + socket);
    }
}
