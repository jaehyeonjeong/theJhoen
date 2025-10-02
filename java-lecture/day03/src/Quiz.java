import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        int nScore = 85;
        // IfTest 클래스에 있는 else if 조건문과 동일하다.
        if (nScore > 90) {
            System.out.println('A');
        }
        if (nScore < 90 && nScore > 80) {
            System.out.println('B');
        }
        if (nScore < 80 && nScore > 70) {
            System.out.println('C');
        }

        // myAge를 이용해서 성인이어야 하고 myTicket(boolean) 이라는 변수가 참일때 입장가능합니다 출력하기
        Scanner scanner = new Scanner(System.in);
        System.out.println("고객님의 나이를 입력해주세요.");
        int myAge = scanner.nextInt();
        System.out.println("고객님의 티겟 여부를 알려주세요.");
        boolean hasTicket = scanner.nextBoolean();
        // boolean 은 true, false 이기 떄문에 == 대입연산자를 작성하는 경우는 거의 없다.
//        if (myAge > 20 && hasTicket) {
//            System.out.println("입장 가능합니다.");
//        } else {
//            System.out.println("입장이 불가능합니다.");
//        }
        // 콜백지우기
//        if (myAge < 20) {
//            System.out.println("미성년자 입니다.");
//            return; // return을 만나면 문장 자체가 실행되지 않는다.
//        }
//        if (hasTicket){
//            System.out.println("입장 가능합니다.");
//            return;
//        }

        // 주어진 숫자가 짝수인지 홀수 인지 검증
        System.out.println("숫자를 입력해주세요.");
        int nNumber = scanner.nextInt();
        if(nNumber % 2 == 1){
            System.out.println("입력하신 숫자는 홀수");
            return; // 또한 return을 잘 작성하면 코드의 가독성을 좋게 할 수 있다.
        }
        System.out.println("입력하신 숫자는 짝수");
    }
}
