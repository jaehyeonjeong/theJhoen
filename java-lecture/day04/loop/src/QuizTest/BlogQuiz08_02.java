package QuizTest;

import java.util.Arrays;

public class BlogQuiz08_02 {
    public static void main(String[] args) {
        int nInputNum = 100000, nTotalNum = 200000;
        int nArray[] = new int[nInputNum];
        // 비교할 배열 변수 하나로 비교하는 시간을 단축 시킴
        boolean usedArray[] = new boolean[nTotalNum + 1];     // 중복 체크용 (0 ~ 100)

        System.out.println(Arrays.toString(usedArray));

        int i = 0;
        long lStartTime = System.nanoTime();
        while(i < nInputNum){
            int random = (int) (Math.random() * nTotalNum) + 1;   // 23,
            // 만약 입력한 값의 중복 체크용 번지수에서 true인 경우 continue 처리
            if(usedArray[random]) {
                continue;
            }
            usedArray[random] = true;
            nArray[i] = random;
            i++;
        }
        long lEndTime = System.nanoTime();
        long lDuration = lEndTime - lStartTime;

        Arrays.sort(nArray);
        System.out.println(Arrays.toString(usedArray));
        System.out.println(Arrays.toString(nArray));
        System.out.println("걸린 시간 : " + lDuration / 1_000_000.0 + "ms");
    }
}
