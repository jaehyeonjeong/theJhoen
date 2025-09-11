import java.util.Scanner;

public class Quiz03 {
    public static void main(String[] args) { // main 매소드도 String[] 을 가지고 있다.
        // 정수 다섯개를 가지는 배열을 만들어서
        // 가장 큰 숫자를 출력해보기
        int nArrayInt [] = new int[5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("5개의 정수를 입력해주세요.");
        for(int i = 0; i < 5; i++){
            int nInput = scanner.nextInt();
            nArrayInt[i] = nInput;
        }

        // 가장 큰 숫자 찾기
        int nMax = 0;
        for(int i = 0; i < 5; i++){
            if(nMax < nArrayInt[i]) nMax = nArrayInt[i];
        }
        System.out.println("입력하신 가장 큰 숫자는 " + nMax + "입니다.");
    }
}
