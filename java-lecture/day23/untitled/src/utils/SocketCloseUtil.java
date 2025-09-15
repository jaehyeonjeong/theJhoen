package utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import static utils.MyLogger.log;

// 자원 회수를 위한 SocketCloseUtil 클래스
public class SocketCloseUtil {
    public static void closeAll(Socket socket, InputStream inputStream, OutputStream outputStream) {
        close(outputStream);
        close(inputStream);
        close(socket);
    }

    public static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }

    public static void close(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }

    public static void close(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                log(e.getMessage());
            }
        }
    }
}
