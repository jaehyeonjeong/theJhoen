package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// 정보 로그 남기는 클래스
public class MyLogger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    // 시간,자리수를 맞추고 난 글자,object
    public static void log(Object object) {
        String time = LocalDateTime.now().format(formatter);
        String string = String.format("%s [%9s] %s\n", time, Thread.currentThread().getName(), object);
        System.out.printf(string);
    }

    // 로그를 기록하는 파일 작성
    // 경로는 temp/log.txt;
    public static void txtPath(Object object) {
        String time = LocalDateTime.now().format(formatter);
        Path path = Path.of("temp/log.txt");
        boolean bfile = Files.notExists(path);
        if (bfile){
            System.out.println("파일 생성");
        }

        String string = String.format("%s [%9s] %s\n", time, Thread.currentThread().getName(), object);

        try(FileOutputStream fileOutputStream = new FileOutputStream(path.toFile(), true)) {
            fileOutputStream.write(string.getBytes());  // 바이트 타입으로 받아야 하기 때문에 getByte를 인용
        }
        catch (IOException e){
            log(e.getMessage());
        }
    }

    public static void logSave(Object object) {
        log(object);
        txtPath(object);
    }
}
