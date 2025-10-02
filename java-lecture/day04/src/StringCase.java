import java.util.Scanner;

public class StringCase {
    public static void main(String[] args) {
        String aa = new String("aa");
        String bb = new String("aa");

        Scanner scanner = new Scanner(System.in);
        int nOper01 = scanner.nextInt();
        String strOper = scanner.next();
        int nOper02 = scanner.nextInt();
        boolean bFlag = true;

//        switch (strOper) {
//            case "+":
//                System.out.println(nOper01 + nOper02);
//                break;
//            case "-":
//                System.out.println(nOper01 - nOper02);
//                break;
//            case "*":
//                System.out.println(nOper01 * nOper02);
//                break;
//            case "/":
//                System.out.println(nOper01 / nOper02);
//                break;
//            default:
//                System.out.println("연산자를 인식하지 못하였습니다.");
//        }

        int nResult = switch (strOper) {
            case "+" -> nOper01 + nOper02;
            case "-" -> nOper01 - nOper02;
            case "*" -> nOper01 * nOper02;
            case "/" -> {
                if (nOper02 == 0) {
                    System.out.println(nOper02 + "은/는 나눌 수 없습니다.");
                    bFlag = false;
                    yield -1;
                }
                yield nOper01 / nOper02;
            }
            default -> {
                bFlag = false;
                System.out.println("연산자를 찾을 수 없습니다.");
                yield -1;
            }
        };
        if (bFlag) {
            System.out.println("정답은 : " + nResult + " 입니다.");
        }
    }
}
