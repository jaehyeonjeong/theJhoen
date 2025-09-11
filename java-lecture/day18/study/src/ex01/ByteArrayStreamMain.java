package ex01;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayStreamMain {
    public static void main(String[] args) throws IOException {
        byte[] input = {1,2,3};
        // 메모리에 쓰기
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(input);
        byteArrayOutputStream.close();

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        byte[] bytes = byteArrayInputStream.readAllBytes();
        System.out.println(Arrays.toString(bytes));
        byteArrayOutputStream.close();

        // close를 하지 않아도 GC의 수거 대상이 되기 때문에 close를 굳이 하지 않아도 된다.
    }
}
