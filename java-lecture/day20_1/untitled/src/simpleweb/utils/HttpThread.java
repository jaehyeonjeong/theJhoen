package simpleweb.utils;

import java.io.*;
import java.net.Socket;

public class HttpThread extends Thread{
    private Socket client;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    HttpThread(Socket client) {
        this.client = client;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            printWriter = new PrintWriter(client.getOutputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        BufferedReader bufferedReader1 = null;
        DataOutputStream outToClient = null;
        try {
            String line = bufferedReader.readLine();
            // line : GET as
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
