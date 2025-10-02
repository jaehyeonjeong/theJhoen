package QuizZip;

import java.util.Arrays;

class ArrayUtil {

    public static int[] concat(int[] a, int[] b) {
        int nAlength = a.length;
        int nBlength = b.length;

        // 하나의 배열을 새로 만들어서 new로 길이 할당
        int[] c = new int[nAlength + nBlength];

        // a를 넣을 때는 0부터 b를 넣을 떄는 a부터 a+b까지 데이터를 넣기
        // 또한 a와 b의 내용물은 각각 0부터 시작
        for (int i = 0; i < nAlength; i++) {
            c[i] = a[i]; // a는 0부터
        }

        for (int i = nAlength; i < nAlength + nBlength; i++) {
            c[i] = b[i - nAlength]; // b의 배열 인덱스도 0부터 해야함
        }

        return c;
    }

    public static void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }
}
