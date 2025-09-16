package blogquiz;

import java.util.Arrays;

public class BlogQuiz03 {
    //1부터 N까지 더하는 로직과, 배열을 정렬하는( Arrays.sort() ) 로직을 각각 실행하고,
    //이 두 가지 로직 모두 "실행에 걸린 시간을 측정"하고 싶다.
    //"실행 시간 측정" 로직은 변하지 않는 부분
    //"실행할 로직"은 바뀌는 부분(1부터 N 합 구하기 vs 배열 정렬)
    //이 문제는 람다를 사용하지 말고 익명 클래스를 사용해서 풀어라
    //
    //문제
    //1. 앞서 정의한 Procedure (추상 메서드 run() ) 함수형 인터페이스를 사용해라.
    //2. measure(Procedure p) 메서드 안에서 실행 전 시간 기록
    //p.run() 실행
    //실행 후 시간 기록
    //걸린 시간 출력
    //3. main() 에서 익명 클래스 두 가지를 만들어 각각 실행 시간을 측정해라.
    //	(1) 1부터 N까지 합을 구하는 로직 ( measure 메서드 호출)
    //	(2) 배열을 정렬하는 로직 ( measure 메서드 호출)
    //measure 메서드는 총 2번 호출된다.
    //(1) 1부터 N까지 합을 구하는 로직 ( measure 메서드 호출)
    //	int N = 100;
    //	long sum = 0;
    //	for (int i = 1; i <= N; i++) {
    //	 sum += i;
    //	}
    //(2) 배열을 정렬하는 로직 ( measure 메서드 호출)
    //		int[] arr = { 4, 3, 2, 1 };
    //		System.out.println("원본 배열: " + Arrays.toString(arr));
    //		Arrays.sort(arr);
    //		System.out.println("배열 정렬: " + Arrays.toString(arr));
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
