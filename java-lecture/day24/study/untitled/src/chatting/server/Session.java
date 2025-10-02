package chatting.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static utils.MyLogger.log;

// 세션을 만들어야 에러가 생기지 않음.
public class Session implements Runnable {
    private final Socket socket;
    private  final DataInputStream input;
    private  final DataOutputStream output;
    private  final CommandManager commandManager;
    private  final SessionManager sessionManager;

    private boolean closed = false;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Session(Socket socket, CommandManager commandManager, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.commandManager = commandManager;
        this.sessionManager = sessionManager;
        this.sessionManager.add(this);      // private은 할당받지 못함
    }

    @Override
    public void run() {
        try {
            while(true) {
                String received = input.readUTF();
                log("client -> server : " + received);
                commandManager.execute(received, this);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            sessionManager.remove(this);
            sessionManager.sendAll(username + "님이 퇴장 하였습니다.");
            close();
        }
    }

    public void close() {
        if(closed) return;
        closed = true;
        log("연결 종료 : " + socket);
    }

    public void send(String message) throws IOException {
        log("server -> client : " + message);
        output.writeUTF(message);
    }
}
