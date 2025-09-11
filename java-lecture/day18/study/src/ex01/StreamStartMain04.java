package ex01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain04 {
    public static void main(String[] args) throws IOException {
        // 외부로 나가는 파일을 찾기 때문에 Exception작업이 필요하다.
        FileOutputStream fileOutputStream = new FileOutputStream("temp/hello.dat");
        byte[] input = {65, 66, 67};
        fileOutputStream.write(input);

        fileOutputStream.close();

        // 버퍼, 버퍼링 : 중간에 덩어리로 하나더 있는 변수
        FileInputStream fileInputStream = new FileInputStream("temp/hello.dat");
        byte[] readBytes = fileInputStream.readAllBytes();      // 데이터를 한번에 가져오는 방법
        // 읽어와야 하는 파일이 작은 경우 : MB 단위 정도
        System.out.println(Arrays.toString(readBytes));
        fileInputStream.close();

        // 자바의 입출력 단위는 byte이다.
    }
}
