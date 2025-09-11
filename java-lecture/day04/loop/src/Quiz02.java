import java.util.Scanner;

public class Quiz02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nSum = 0, nCount = 0;
        System.out.println("5개의 정수를 입력해주새요. 그중에 양의 정수만 합산이 될 것입니다.");
        // 변수의 scope : 변수의 유효범위.
        int nInput;
        // 지역변수를 쓰는것을 추천하는 방향이다 (작게쓰기 위함)
        for(int i = 0; i < 5; i++) {
            nInput = scanner.nextInt();
            // int nInput = scanner.nextInt();  // 이렇게 지역변수로 작성하는 방량이 좋음
            if(nInput < 0) {
                nCount++;
                continue;
            }
            nSum += nInput;
        }
        System.out.println("입력한 음수의 개수 : " + nCount);
        System.out.println("양수의 합은 : " + nSum);
    }
}
