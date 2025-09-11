package old;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FileName {
    public static void main(String[] args) throws IOException {
        //File : java file
        //Files : nio file
        File file = new  File("temp/example.hwp");       // 못만드는 확장자가 없다.
        File directory = new  File("temp/exampleDir");
        // File이 파일과 디렉토리 모두 혼용해서 다룰 수 있다.
        System.out.println("File exist : " + file.exists());
        System.out.println("Directory exist : " + directory.exists());

        // 2. 파일 만들기
        boolean created = file.createNewFile();
        System.out.println(created);            // 파일이 이미 있으면 false
        System.out.println("-----------------");
        System.out.println("File exist : " + file.exists());

        System.out.println("==================");
        boolean dirCrate = directory.mkdir();
        System.out.println(dirCrate);
        System.out.println("Directory exist : " + directory.exists());

//        System.out.println("==================");
//        boolean fileDelete = file.delete();
//        System.out.println("File deleted : " + fileDelete); // 파일 삭제도 가능

        System.out.println("is file : " + file.isFile());
        System.out.println("is directory : " + directory.isFile());     // 존재 및 파일인지 확인

        System.out.println("is file : " + file.isDirectory());
        System.out.println("is directory : " + directory.isDirectory()); // 존재 및 폴더인지 확인

        // 사용하는 이유는 한서버에 저장하는 파일의 이름이 같으면 덮어씌어지는 문제를 방지하기 위함.
        System.out.println(file.getName());
        File renameFile = new  File("temp/renameExample.txt");
        boolean rename = file.renameTo(renameFile);
        System.out.println(rename);

        // epoch 시간 기반으로 한 최근 수정일 기록
        long lastModified = renameFile.lastModified();
        System.out.println("lastModified : " + lastModified);
        System.out.println("Date(원래는 쓰면 안됨) : " + new  Date(lastModified));


        LocalDateTime dateTime = Instant.ofEpochMilli(lastModified)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        System.out.println(dateTime);

        // LocalDateTime // Instant // Duration
        Instant instant = Instant.ofEpochMilli(lastModified);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime);
        String formatTime = zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("정식 버전 : " + formatTime);

        //nio를 많이 쓴다.

        File path = new File("temp/..");
        //경로 찾기
        System.out.println("path.getPath() === " + path.getPath()); // 프로그램 기준 경로
        System.out.println("path.getAbsolutePath() === " + path.getAbsolutePath()); // 있는 그대로보여줌
        System.out.println("path.getCanonicalPath() === " + path.getCanonicalPath()); // 완벽한 경로를 나타냄(알고있는 경로)

        //경로 찾기
        System.out.println("file.getPath() === " + file.getPath()); // 프로그램 기준 경로
        System.out.println("file.getAbsolutePath() === " + file.getAbsolutePath()); // 전체 경로
        System.out.println("file.getCanonicalPath() === " + file.getCanonicalPath()); // 운영체제에 따라서 다르게 나올 수 있음

        File[] files = path.listFiles();
        assert files != null;
        for(File f : files) {
            if(f.isFile()) {
                System.out.println("find file = " + f);
            }
        }
        // 옛날에는 File 가지고 Path File을 둘다 썼었다.
        // 지금은 nio에서 지원해주는 Files, Path를 자주 사용한다. 해당 클래스 부터 사용하는걸 추천

    }
}
