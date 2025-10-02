package ex01;

import java.io.FileInputStream;
import java.io.FileNotFoundException; // 파일이 있는지 없는지만 체크
import java.io.FileOutputStream;
import java.io.IOException; // write 메소드를 사용하기 위한 FileNotFoundException의 상위 클래스

public class StreamStartMain {
    public static void main(String[] args) throws IOException {
        // 외부로 나가는 파일을 찾기 때문에 Exception작업이 필요하다.
        FileOutputStream fileOutputStream = new FileOutputStream("temp/hello.dat");
        fileOutputStream.write(65);
        fileOutputStream.write(66);
        fileOutputStream.write(67);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp/hello.dat");
        System.out.println(fileInputStream.read());
        System.out.println(fileInputStream.read());
        System.out.println(fileInputStream.read());
        System.out.println(fileInputStream.read());     // -1은 문서의 끝 eof
        fileInputStream.close();
    }
}
