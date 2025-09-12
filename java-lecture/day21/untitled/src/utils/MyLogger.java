package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 정보 로그 남기는 클래스
public class MyLogger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    // 시간,자리수를 맞추고 난 글자,object
    public static void log(Object object) {
        String time = LocalDateTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), object);
    }
}
