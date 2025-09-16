package chatting.command;

import chatting.server.Session;

import java.io.IOException;

public interface Command {
    void execute(String[] args, Session session) throws IOException;        // 실행

}
