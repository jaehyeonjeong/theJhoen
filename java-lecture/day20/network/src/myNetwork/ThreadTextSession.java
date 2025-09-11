package myNetwork;

import java.net.Socket;

public class ThreadTextSession implements Runnable{
    private static String strText;

    public static void textOutput(String text, Socket socket) {
        strText = String.format(socket.getPort() + " : " + text);
    }

    @Override
    public void run() {
        System.out.println(strText);
    }
}
