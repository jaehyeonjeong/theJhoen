package blogquiz;

import java.time.Duration;
import java.time.LocalDateTime;

public class BlogQuiz05 {
    //5.
    //LocalDateTime event와 LocalDateTime now로부터 "n시간 m분 s초 전" 문자열을 만들어라.
    //(n=0이면 해당 단위 생략 가능)
    public static void main(String[] args) {
        LocalDateTime event = LocalDateTime.of(2025, 9, 6, 19, 0, 0);
        LocalDateTime now = LocalDateTime.now();

        Duration duration = Duration.between(now, event);

        long lHour = duration.toHours();
        long lMinute = duration.toMinutesPart();
        long lSecond = duration.toSecondsPart();

        System.out.println("""
                %d시간 %d분 %d초전"""
                .formatted(lHour, lMinute, lSecond));

    }
}
