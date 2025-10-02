package chatting.server;

import java.io.IOException;

public class CommandManager01 implements CommandManager {
    private final SessionManager sessionManager;

    public CommandManager01(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        if(totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        }
        sessionManager.sendAll(totalMessage);   // 세션 메니저를 통해 모든 클라이언트에 메세지를 보냄.
    }
}
