package copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyFileMain4 {
    private static final int FILE_SIZE = 1024 * 1024 * 200;
    private static final int FILE_DIST = 1024 * 1024;

    public static void main(String[] args) throws IOException {
        String fileName = "temp/copy.dat";
        long startTime = System.currentTimeMillis();

        Path source = Path.of(fileName);
        Path target = Path.of("temp/copy_new_03.dat");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);    // 복사 붙여넣기...
        // 이는 시스템에 있는 운영체제의 도움을 받아서 사용(자바를 거치지 않음) -> copy.dat - copy_new.dat
        // 원래는 이런 시스템 : copy.dat - java - copy_new.dat 시스템을 거침


        long endTime = System.currentTimeMillis();

        System.out.println("File Created : " + fileName);
        System.out.println("File Size : " + FILE_SIZE / FILE_DIST + "MB");
        System.out.println("Elapsed Time : " + (endTime - startTime) + "ms");

        // temp/copy.dat을 복사되는 날짜 형식으로 파일 이름을 바꾸어서 저장
        // tmep/copy_20250911113940123;
    }
}
