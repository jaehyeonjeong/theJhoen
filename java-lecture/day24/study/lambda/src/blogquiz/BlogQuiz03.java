package blogquiz;

import java.util.Arrays;

public class BlogQuiz03 {
    public static void main(String[] args) {
        // 람다 사용 x, 익명 클래스 사용
        Procedure procedure02 = new Procedure() {
            @Override
            public void run() {
                int[] ints = {4,3,2,1};
                System.out.println("원본 배열 : " + Arrays.toString(ints));
                Arrays.sort(ints);
                System.out.println("배열 정렬 : " + Arrays.toString(ints));
            }
        };

        Procedure procedure01 = new Procedure() {
            @Override
            public void run() {
                int N = 100;
                long sum = 0;
                for (int i = 1; i <= N; i++) {
                    sum += i;
                }
                System.out.println("[1부터 "+ N +"까지 합] 결과 : " + sum);
            }
        };
        measure(procedure01);
        measure(procedure02);
    }
    public static void measure(Procedure p)
    {
        long startNs = System.nanoTime();
        p.run();
        long endNs = System.nanoTime();
        System.out.println("실행 시간 : " + (endNs - startNs) + "ns");
    }

}
