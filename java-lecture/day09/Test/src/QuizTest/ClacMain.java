package QuizTest;

import java.util.Scanner;

public class ClacMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("두 점수와 연산자를 입력하세요. ex) 1, 2, +");

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String operator = scanner.next();

        int result = 0;


//
//
//        switch(operator) {
//            case "+":
//                Add add = new Add(a, b);
//                result = add.calculator();
//                break;
//            case "-":
//                Sub sub = new Sub(a, b);
//                result = sub.calculator();
//                break;
//            case "*":
//                Mux mux = new Mux(a, b);
//                result = mux.calculator();
//                break;
//            case "/":
//                Div div = new Div(a, b);
//                dResult = div.calculator();
//                break;
//            default:
//                System.out.println("연산자를 잘못 입력하셧습니다.");
//                System.exit(0);
//                break;
//        }

        double dResult = switch(operator) {
            case "+" -> {
                Add add = new Add(a, b);
                yield add.calculator();
            }
            case "-" -> {
                Sub sub = new Sub(a, b);
                yield sub.calculator();
            }
            case "*" -> {
                Mux mux = new Mux(a, b);
                yield mux.calculator();
            }
            case "/" -> {
                Div div = new Div(a, b);
                yield div.calculator();
            }
            default -> {
                System.out.println("연산자를 잘못 입력하였습니다");
                yield -1;
            }
        };



        System.out.println("결과 : " + dResult);
    }
}
