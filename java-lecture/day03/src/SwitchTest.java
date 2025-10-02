import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        // Switch 가 있는데 if문이랑 비슷하다
        // Switch() 안에 식이 들어가고 해당하는 값이 맞는 case 문에 들어간다.
        // 조건자체를 만족하지 못했을 때 default로 빠진다.
        int nScore = 100;
        // switch case 문은 항상 break를 작성해야하고, switch 안에는 결과값을 나타낼 수 있는 식이 필요하다.

        // 중요한건 case안에는 "문자, 문자열, 정수"들만 처리할 수 있다.
        // char는 정수로 변환이 가능
        switch (nScore / 10) {
            case 10:
                System.out.println('A');
                break;
            case 9:
                System.out.println('B');
                break;
            case 8:
                System.out.println('C');
                break;
            case '7':
                System.out.println('D');
                break;
            default:
                System.out.println('E');
                break;
        }

        //java 14버전부터 등장한 expression이라는게 나옴 : switch 식이라는게 탄생함
        int nNumber = 2;
        String result = switch (nNumber) {
            case 1 -> "one";
            case 2 -> "two";
            default -> "etc";
        };
        System.out.println(result);

        Scanner scanner = new Scanner(System.in);
        System.out.println("점수를 입력하세요.");
        nScore = scanner.nextInt();
        char chScore = switch (nScore / 10) {
            case 10, 9 -> {
                System.out.println("수석입니다.");
                yield 'A';
            }
            case 8 -> {
                System.out.println("차석입니다.");
                yield 'B';
            }
            case 7 -> 'C';
            case 6 -> 'D';
            case 5 -> 'E';
            default -> {
                System.out.println("재수강 해야합니다.");
                yield 'F'; // yield가 return하는 역할을 하기 때문에 항시 맨아래로 작성해야한다.
            }
        };
        System.out.println(chScore);
    }
}
