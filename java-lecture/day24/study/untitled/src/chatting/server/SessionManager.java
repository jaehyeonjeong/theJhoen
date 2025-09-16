package chatting.server;

import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    private List<Session> sessions = new ArrayList<>();
    private synchronized void add(Session session) {
        sessions.add(session);

    }

    private synchronized void remove(Session session) {
        sessions.remove(session);

    }

    public synchronized void closedAll() {
        for(Session session : sessions) {
            session.close();
        }
        sessions.clear();
    }
}
