package chatting.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utils.MyLogger.log;

public class SessionManager {
    private List<Session> sessions = new ArrayList<>();

    public synchronized void add(Session session) {
        sessions.add(session);

    }

    public synchronized void remove(Session session) {
        sessions.remove(session);

    }

    public synchronized void closedAll() {
        for(Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }

    // client -> server -> another client (session이 관리)
    public synchronized void sendAll(String message) {
        for(Session session : sessions) {
            try {
                session.send(message);
            } catch (IOException e) {
                log(e);
            }
        }
    }
}
