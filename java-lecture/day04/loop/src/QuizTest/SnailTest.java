package QuizTest;

import java.util.Arrays;

public class SnailTest {
    public static void main(String[] args) {
        int nCol, nRow, a = 1; // a = 배열에 추가할 인자;
        // 가로 세로 길이 설정
        nCol = 6;
        nRow = 6;

        int nArray[][] = new int[nCol][nRow]; // 0으로 자동으로 초기화
        System.out.println(Arrays.deepToString(nArray));

        // 시작 점
        int i = 0, j = 0;
        nArray[0][0] = a;
        a++; // a = 2;

        // 방향에 따른 달팽이 알고리즘 시작
        while(a <= nCol * nRow) { // nCol, nRow 길이에 따른 배열 설정
            while (j + 1 < nRow && nArray[i][j + 1] == 0) { // 오른쪽
                j++;
                nArray[i][j] = a;
                a++;
            }
            while (i + 1 < nCol && nArray[i + 1][j] == 0) { // 아래
                i++;
                nArray[i][j] = a;
                a++;
            }
            while (j - 1 >= 0 && nArray[i][j - 1] == 0) { // 왼쪽
                j--;
                nArray[i][j] = a;
                a++;
            }
            while (i -1 >= 0 && nArray[i - 1][j] == 0) { // 위
                i--;
                nArray[i][j] = a;
                a++;
            }
        }
        System.out.println(Arrays.deepToString(nArray));

        for(int arr01[] : nArray){
            for(int arr: arr01) {
                System.out.print(arr + "\t");
            }
            System.out.println();
        }
    }
}
