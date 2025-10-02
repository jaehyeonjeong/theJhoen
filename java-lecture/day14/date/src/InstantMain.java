import java.time.Instant;

public class InstantMain {
    public static void main(String[] args) {
        // 어느 시점(1970.1.1 00)을 기준으로 흘러온 시간 (초)
        Instant now = Instant.now();
        System.out.println(now);

        // 1970년 1월 1일로 떨어져나옴
        Instant epochStart = Instant.ofEpochSecond(0);
        System.out.println("epochStart === " + epochStart);

        // 로그 작성 같은 걸 할때 많이 쓰임.
        //
    }
}
