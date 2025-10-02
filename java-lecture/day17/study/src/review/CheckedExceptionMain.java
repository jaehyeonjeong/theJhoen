package review;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptionMain {
    public static void main(String[] args) {

        // FileReader는 사용자가 핸들링을 해야하는 checked Exception 이다. Exception 상속
        try {
            new BufferedReader(new FileReader("test.txt")); // 강제로 예외를 터트려서 출력됨.
            // 위의 구문을 실행하고 예외가 발생하면 catch로 이동
        } catch (FileNotFoundException e) {
            System.out.println("파일 처리 중 예외 발생");
            System.out.println(e.getMessage());
//            e.printStackTrace();  // 디테일한 내용을 상세하게 알려주는 것
//            throw new RuntimeException(e);
        } finally {
            System.out.println("여기 있는 구문은 무조건 실행");
        }
    }
}
