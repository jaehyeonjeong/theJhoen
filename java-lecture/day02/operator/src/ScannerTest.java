//import java.util.Scanner;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in); // 시스템이 가지는 인풋값을 출력하기 위한 선언

        Scanner scanner = new Scanner(System.in); // Scanner 객체를 먼저 입력하기만 하면 import는 자동으로 나옴
        // 키보드를 입력할 때만 Sysrem.in을 사용한다.
        // 웬만하면 import를 먼저 쓰지 않고 객체를 먼저 작성해서 import가 자동으로 들여쓰기 되는 방향으로 가는게 맞음

        // Scanner는 object 타입이당
//        String name = scanner.next(); // 공백 인식 후 뒤에있는 문자 인식 안됨
//        String name = scanner.nextLine();   // 공백 무시하고 전체 문자 인식
//        System.out.println("키보드로 입력한 문자열은 : " + name);
        // 설명 : 텍스트를 입력하면 스캐너 객체가 name 변수에 입력된다.

        // 10  +  10
        int num = scanner.nextInt();    // 정수를 인식하기 위한 변수와 객체 선언
        System.out.println(num + 10);

        double doubleNum = scanner.nextDouble();
        System.out.println(doubleNum + 10);

        boolean bNum = scanner.nextBoolean();
        System.out.println(bNum);
    }
}
