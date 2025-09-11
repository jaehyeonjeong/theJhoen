import java.util.Scanner;

public class OperatorTest {
    public static void main(String[] args) {

        // 연산 (operating)
        // 프로그래밍을 돌리는 두개 문(statement)->동작하는 최소단위, 식(expression)->값을 뱉어냄

        int num01 = 20;
        int num02 = 3; // 나머지 값 : 0 ~ 2
        // 산술 연산자
//        System.out.println("num01 + num02 : " + (num01 + num02));
//        System.out.println("num01 * num02 : " + (num01 * num02));
//        System.out.println("num01 - num02 : " + (num01 - num02));
//        System.out.println("num01 / num02 : " + (num01 / num02));
//        System.out.println("num01 % num02 : " + (num01 % num02));

        // println안에 있는 문자열을 먼저 인식해서 정수 변수도 문자열 데이터로 인식 해서 문자열로 출력됨
//        System.out.printf("num01 + num02 = %d %f", num01 + num02, 10.9); // format된 형태로 출력 요청
//
//        System.out.printf("num01 - num02 : %d \n", num01 - num02);
//        System.out.printf("num01 / num02 : %d \n", num01 / num02);
//        System.out.printf("num01 + num02 : %d \n", num01 + num02);
//        System.out.printf("num01 * num02 : %d \n", num01 * num02);
//        System.out.printf("num01 %% num02 : %d \n", num01 % num02);

        // 증감 연산자 : 산술 식이 아님
        num01 = num01 + 1;
        System.out.println(num01);
        num01 += 1;
        System.out.println(num01);
        num01 = +1;
        System.out.println(num01);
        num01++; // 증감 연산자
        System.out.println(num01);
        int num03 = num01++; // num03은 우선순위에서 밀림
        num03++;
        System.out.println(num03);
        System.out.println(num01);
        num01 += 2;
        System.out.println(num01);
        num01 -= 2;
        System.out.println(num01);
        num01 *= 2;
        System.out.println(num01);
        num01 /= 2;
        System.out.println(num01);
        num01 %= 2;
        System.out.println(num01);

    }
}
