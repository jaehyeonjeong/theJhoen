package Arrays;

public class SnailArray {
    public static void main(String[] args) {
        // 배열과 반복문을 이요해서 제작
        // left = 0, right = 4, bottom = 4; top = 0; 1. 경계를 지정

        int n = 10;

        //int nTotal = n * n;
        // Math.pow(4, 2);
        int nLeft = 0, nTop = 0, nBottom = n - 1, nRight = n - 1; // bottom과 right는 n - 1 까지 진행
        int nNumber = 1;
        int nArray[][] = new int[n][n];
        while (nLeft <= nRight && nTop <= nBottom) {

            // right 이동
            for(int i = nLeft; i <= nRight; i++) {
                nArray[nTop][i] = nNumber; // [0][0] = 1;, [0][1] = 2, [0][2] = 3
                nNumber++;
            }
            nTop++;

            // bottom 이동
            for(int i = nTop; i <= nBottom; i++) {
                nArray[i][nRight] = nNumber;
                nNumber++;
            }
            nRight--;

            // left 이동
            for(int i = nRight; i >= nLeft; i--){
                nArray[nBottom][i] = nNumber;
                nNumber++;
            }
            nBottom--;

            // top 이동
            for(int i = nBottom; i >= nTop ; i--) {
                nArray[i][nLeft] = nNumber;
                nNumber++;
            }
            nLeft++;
        }

        for(int arr01[] : nArray) {
            for(int arr : arr01){
                System.out.print(arr + "\t");
            }
            System.out.println();
        }
    }
}
