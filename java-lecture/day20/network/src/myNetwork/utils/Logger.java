package myNetwork.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static final DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    // 오브젝트를 파라미터로 두면 무슨데이터든 다 받을 수 있음.
    public static void log(Object object) {
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%3s3] %s\n",
                time,
                Thread.currentThread().getName(),
                object);
    }
}
