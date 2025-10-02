package review;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

public class FIleMain {
    public static void main(String[] args) throws IOException {
        System.out.println();
        String filePath = "temp/directory/memo.txt";
        Path path = Paths.get(filePath);

        FileTime fileTime = Files.getLastModifiedTime(path);
        Instant instant = fileTime.toInstant();

        ZonedDateTime localTime = instant.atZone(ZoneId.systemDefault());
        System.out.println("현재 시간으로 바꾸기 : " + localTime);
        //메서드 체이닝 : 메서드를 이어 붙인다는 뜻
        ZonedDateTime localTime02 = Files.getLastModifiedTime(path).toInstant().atZone(ZoneId.systemDefault());
        System.out.println("현지 시간으로 바꾸기 : " + localTime02);


        String localTime03 = localTime02.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("현지 시간을 포멧을 사용해서 바꾸기 : " + localTime03);

        System.out.println("============================");
        // 전체를 통괄하는 방법 -> BasicFileAttributes를 사용하면 된다
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Create Time : " + basicFileAttributes.creationTime());
        System.out.println("is directory : " + basicFileAttributes.isDirectory());
        // isRegularFile 은 파일이냐 디렉토리이냐를 구분
        System.out.println("is regular file : " + basicFileAttributes.isRegularFile());

        System.out.println("file size : " + basicFileAttributes.size());
        System.out.println("last Time Access : " + basicFileAttributes.lastAccessTime());
//        System.out.println(basicFileAttributes.);

        // temp 폴더에 sample.txt 파이을 하나 만들기 없으면 만들고 있으면 만들지 않기
        // 1 번째 방법
        try {
            System.out.println("파일을 만들겠습니다.");
            String strPath = "./temp/sample.txt";
            Path originPath = Paths.get(strPath);
            boolean bExistPath = Files.createFile(originPath).isAbsolute();
            if (!bExistPath) {
                System.out.println("파일을 생성하였습니다.");
            }
        } catch (FileAlreadyExistsException e) {
            System.out.println("파일은 이미 존재합니다.");
        }

        // 2번째 방법
        Path tempDir = Paths.get("tmep");
//        Path filePath2 = Paths.get("tmep/sample.txt");
        Path filePath2 = tempDir.resolve("sample.txt"); // 디렉토리와 연결해서 사용
        Files.deleteIfExists(filePath2);

        if(Files.notExists(tempDir)) {
            System.out.println("디렉토리를 생성하였습니다.");
            Files.createDirectory(tempDir);
        }
        else {
            System.out.println("이미 존재하는 디렉토리입니다.");
        }
        if(Files.notExists(filePath2)) {
            System.out.println("파일을 생성하였습니다.");
            Files.createFile(filePath2);
        }
        else {
            System.out.println("이미 존재한 파일입니다.");
        }

        System.out.println("========================");
        Path path1 = Path.of("tmep/..");
        System.out.println("Absolute path1 : " + path1.toAbsolutePath());   // 실제 디렉토리나 파일이 없어도 예외가 발생하지 않는다.(이건 단순 문자열)
        System.out.println("RealPath path1 : " + path1.toRealPath());       // 흔히 알고있는 경로 (이걸 쓰는걸 추천)
        Stream<Path> pathStream = Files.list(path1);
        List<Path> pathList = pathStream.toList();
        pathStream.close();
        for(Path p : pathList) {
            System.out.println(Files.isRegularFile(p) ? "F" : "D" + " " + p.getFileName());
        }
        // Reader Writer

    }
}
