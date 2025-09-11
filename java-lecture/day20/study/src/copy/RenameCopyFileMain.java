package copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class RenameCopyFileMain {
    private static final int FILE_DIST = 1024 * 1024;

    public static void main(String[] args) throws IOException {
        String fileName = "temp/copy_new_02.dat";

        Path path = Path.of(fileName);
        if (Files.exists(path)) {
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
            UUID uuid = UUID.randomUUID();
            System.out.println(date);
//            System.out.println(uuid);
            String file = path.getFileName().toString();
            System.out.println(file);
            int dotIdx = file.lastIndexOf(".");
            System.out.println(dotIdx);
            String name = file.substring(0, dotIdx);                // 확장자 전 파일 이름
            String extension = file.substring(dotIdx + 1);  // 확장자
            if (!(extension.equals("jpg") || extension.equals("jpeg")
                    || extension.equals("png") || extension.equals("gif") || extension.equals("dat"))) {
                System.out.println("이미지 파일만 쓸 수 있습니다.");
                //return
            } else {
                // Files Path 구분이 필요
                System.out.println(name + " --- " + extension);

                String newFileName = name + "_" + date + "." + extension;
                Path newFile = path.getParent().resolve(newFileName);
                Files.move(path, newFile, StandardCopyOption.REPLACE_EXISTING);

                // 확장자가 jpg, jpeg, png, gif가 아니면 이미지 파일만 쓸 수 있는지 확인
                System.out.println("이름 변경 완료");
            }
        }
    }
}
