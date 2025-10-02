package backjun;

import java.util.Scanner;

public class TurretMain {
    public static void main(String[] args) {
        //3
        //0 0 13 40 0 37
        //0 0 3 0 7 4
        //1 1 1 1 1 5

        // C 가 있을 수 있는 위치
        //2
        //1
        //0

        // 입력 순서
        // A의 좌표 A가 측정한 상대 C의 거리
        // (x1 y1)  r1
        // B의 좌표 B가 측정한 상대 C의 거리
        // (x2 y2)  r2
        Scanner scanner = new Scanner(System.in);

        System.out.println("반복할 횟수의 수를 입력하세요.");
        System.out.print("입력 : ");

        int nCount = scanner.nextInt();
        scanner.nextLine();

        int [][] ints = new int[nCount][6];

        int [] answer = new int[nCount];

        for(int i = 0; i < nCount; i++) {
            String line = scanner.nextLine();
            String[] strings = line.split(" ");

//            System.out.println(strings);

            int n = 0;
            for(String s : strings) {
                ints[i][n] =  Integer.parseInt(s);
                n++;
            }

            // 여기서 계산
            // ints[0] ~ [6] x1 ~ r2

        }

        // 출력
        for(int i = 0; i < nCount; i++) {
            for(int j = 0; j < 6; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
}
