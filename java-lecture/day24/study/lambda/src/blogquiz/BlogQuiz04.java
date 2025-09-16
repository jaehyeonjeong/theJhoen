package blogquiz;

import java.util.Arrays;

public class BlogQuiz04 {
    //이전 문제에서 익명 클래스로 작성한 부분을 람다로 변경해라.
    //measure() 메서드와 Procedure 인터페이스는 그대로 둔다.
    //main() 에서 익명 클래스를 사용하지 말고, 람다를 이용하여 더욱 간결하게 코드를 작성해라.
    public static void main(String[] args) {
        Procedure procedure01 = () -> {
            int N = 100;
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += i;
            }
            System.out.println("[1부터 "+ N +"까지 합] 결과 : " + sum);
        };

        Procedure procedure02 = () -> {
            int[] ints = {4,3,2,1};
            System.out.println("원본 배열 : " + Arrays.toString(ints));
            Arrays.sort(ints);
            System.out.println("배열 정렬 : " + Arrays.toString(ints));
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
