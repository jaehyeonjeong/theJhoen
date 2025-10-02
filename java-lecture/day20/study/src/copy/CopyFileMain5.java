package copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CopyFileMain5 {
    private static final int FILE_DIST = 1024 * 1024;

    public static void main(String[] args) throws IOException {
        String fileName = "temp/copy.dat";
        long startTime = System.currentTimeMillis();

        // temp/copy.dat을 복사되는 날짜 형식으로 파일 이름을 바꾸어서 저장
        // temp/copy_20250911113940123;
        Path source = Path.of(fileName);

        String localTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
        System.out.println("현재시간 : " + localTime);

        String strFormatFile = "temp/copy_" + localTime + ".dat";
        Path target = Path.of(strFormatFile);

        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);    // 복사 붙여넣기...
        // 이는 시스템에 있는 운영체제의 도움을 받아서 사용(자바를 거치지 않음) -> copy.dat - copy_new.dat
        // 원래는 이런 시스템 : copy.dat - java - copy_new.dat 시스템을 거침
        long endTime = System.currentTimeMillis();

        System.out.println("File Created : " + fileName);
        System.out.println("File Size : " + target.toFile().length() / FILE_DIST + "MB");
        System.out.println("Elapsed Time : " + (endTime - startTime) + "ms");
    }
}
