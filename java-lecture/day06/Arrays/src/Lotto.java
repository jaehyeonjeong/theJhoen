import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
    public static void main(String[] args) {
        // 예제
        int nArrLength = 6;
        int nArrLotto[] = new int[nArrLength];
        // 중복 제거를 위한 boolean도 만들 수 있음
        boolean bArrCompare[] = new boolean[45];

        System.out.print("게임을 돌릴 횟수는? : ");
        Scanner scanner = new Scanner(System.in);
        int nGameCount = scanner.nextInt();

        for(int nCount = 0; nCount < nGameCount; nCount++) {
            Arrays.fill(bArrCompare, false);
            for (int i = 0; i < nArrLength; i++) {
                int nNumber = (int) (Math.random() * 45);
                // 중복 제거

                if (!bArrCompare[nNumber]) {  // boolean 자리를 봐야하기 때문에 nNumber를 써줘야 한다.
                    nArrLotto[i] = nNumber + 1;
                    bArrCompare[nNumber] = true; // boolean 배열에 선언되는 숫자들은 기존 Number보다 작아랴 한다.
                }
//                else {
//                    i--;
//                }
//            for(int j = 0; j < i; j++){
//                // 만약 이전에 나온 배열안에 같은 수가 존재하는 경우 i--후 break;
//                if(nNumber == nArrLotto[j]) {
//                    bArrCompare[i] = true;
//                    break;
//                }
//            }
            }
            Arrays.sort(nArrLotto);
            System.out.println(Arrays.toString(nArrLotto));
        }
    }
}
