package ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain03 {
    public static void main(String[] args) throws IOException {
        // 외부로 나가는 파일을 찾기 때문에 Exception작업이 필요하다.
        FileOutputStream fileOutputStream = new FileOutputStream("temp/hello.dat");
        byte[] input = {65, 66, 67};
        fileOutputStream.write(input);

        fileOutputStream.close();

        // 버퍼, 버퍼링 : 중간에 덩어리로 하나더 있는 변수
        FileInputStream fileInputStream = new FileInputStream("temp/hello.dat");
        byte[] buffer = new byte[10];
        // 대용량인 데이터는 버퍼를 다루는게 좋다.
//        int readCount = fileInputStream.read(buffer, 0, 10);    // 2번째 파라미터는 남은 공간에 채울 수
        int readCount = fileInputStream.read(buffer);
        System.out.println("readCount === " + readCount);
        System.out.println(Arrays.toString(buffer));

        fileInputStream.close();
    }
}
