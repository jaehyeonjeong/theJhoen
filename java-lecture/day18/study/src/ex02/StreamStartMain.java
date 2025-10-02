package ex02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain {
    public static void main(String[] args) throws IOException {
        // 외부로 나가는 파일을 찾기 때문에 Exception작업이 필요하다.
        FileOutputStream fileOutputStream = new FileOutputStream("temp/hello.dat");
        fileOutputStream.write(65); // A    // 소스상에서는 숫자 정수를 입력했지만 문자로 디코딩해서 Char즉 문자로 반환한다.
        fileOutputStream.write(66); // B
        fileOutputStream.write(67); // C
        // 저장이 될 떄에는 65, 66, 67 Ascii 문자로 바꿔서 저장한다.
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp/hello.dat");
        int data;
        while((data=fileInputStream.read()) != -1) {
            System.out.println(data);
        }
        fileInputStream.close();
    }
}
