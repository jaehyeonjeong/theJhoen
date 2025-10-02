package myNetwork.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static myNetwork.utils.Logger.log;

// 자원 회수를 위한 CloseUtil 클래스
public class SocketCloseUtil {
    public static void closeAll(Socket socket, InputStream inputStream, OutputStream outputStream)  {
        close(socket);
        close(inputStream);
        close(outputStream);
    }

    public static void close(InputStream inputStream) {
        if(inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                log(e);
            }
        }
    }

    public static void close(OutputStream outputStream) {
        if(outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                log(e);
            }
        }
    }

    public static void close(Socket socket) {
        if(socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                log(e);
            }
        }
    }
}
