import java.util.Scanner;

public class LogicalOperator {
    public static void main(String[] args) {
        // 논리 연산자
        int num01 = 10;
        int num02 = 20;
        System.out.println(num01 > num02 && num01 < num02); // AND(그리고) 둘 중에 하나라도 0이면 0
        System.out.println(num01 > num02 || num01 < num02); // OR(또는) 둘 중에 하나라도 1이면 1
        System.out.println(num01 < num02 ^ num01 < num02); // XOR (서로 다른) 같으면 true, 다르면 false
        System.out.println(!(num01 > num02)); // 부정 Not 연산자

        // 삼항 연산자
        int x = 5;
        int y = 3;
        String result = x > y ? "5는 3보다 큰다" : "5는 3보다 작다";
        System.out.println(result);


        // Quiz  두수의 차를  구하는 식을 삼항연산자로 구하시오.
        Scanner scanner = new Scanner(System.in);

        System.out.println("입력한 두 수의 차를 나타내겠습니다.");
        System.out.print("첫번째 정수를 입력해주세요 : ");
        int a = scanner.nextInt();
        System.out.print("두번째 정수를 입력해주세요 : ");
        int b = scanner.nextInt();
        int result02 = a > b ? a - b : b - a;
        System.out.println(result02);
    }
}
