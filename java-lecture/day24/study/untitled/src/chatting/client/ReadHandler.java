package chatting.client;

import java.io.DataInputStream;
import java.io.IOException;

import static utils.MyLogger.log;
import static utils.ThreadUtil.sleep;

// 읽는것을 제어하는 클래스
public class ReadHandler implements Runnable{
    private final DataInputStream input;
    public boolean closed = false;
    private final Client client;

    public ReadHandler(DataInputStream input, Client client) {
        this.input = input;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            while(true) {
                String received = input.readUTF();
                System.out.println(received);
            }
        } catch (IOException e) {
            log(e);
        }

    }

    public synchronized void close() {
        if(closed) return;
        closed = true;
        log("readHandler 종료");
    }
}
