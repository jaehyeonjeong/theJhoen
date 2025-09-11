package text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;


public class ReadText01 {
    public static void main(String[] args) throws IOException {
        String string = "abc\n가나다\n안녕하세요 정재현 입니다.";
        System.out.println(string);

        // 로그 만드는데 용이 하겠다~~
        Path path = Path.of("temp/hello.txt");

        Files.writeString(path,string, StandardCharsets.UTF_8);

        System.out.println("======================");
        String readStr = Files.readString(path, StandardCharsets.UTF_8);
        System.out.println(readStr);

        // 원래는 Bufferd를 써야하는데 간단하게는 위처럼 사용할 수 있다.
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter())
    }
}
