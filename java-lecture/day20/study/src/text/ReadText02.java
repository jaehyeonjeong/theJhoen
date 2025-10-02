package text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class ReadText02 {
    public static void main(String[] args) throws IOException {
        String string = "abc\n가나다\n안녕하세요 정재현 입니다.";
        System.out.println(string);

        // 로그 만드는데 용이 하겠다~~
        Path path = Path.of("temp/hello.txt");

        Files.writeString(path,string, StandardCharsets.UTF_8);

        System.out.println("======================");

        // 한 줄씩 읽어줌
        // 용량이 작으면 readAllLine으로
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);  // 한 번에 다 읽어서 한 줄씩 리스트에 담기
//        Files.lines(path);    // 한 줄씩 읽어서 stream으로 반환, 용량이 크다면 lines를 사용
        for(int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + " : " + lines.get(i));
        }
    }
}
