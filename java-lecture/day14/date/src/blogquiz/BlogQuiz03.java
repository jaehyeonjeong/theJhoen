package blogquiz;

import java.time.Duration;
import java.time.LocalDateTime;

public class BlogQuiz03 {
    //3.
    //하루 근무 시작·종료 LocalDateTime start/end가 주어지고,
    //중간에 12:00~13:00은 휴게로 제외한다. 총 근무 시간을 분 단위로 반환하라. hour -= 1;
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2025, 9, 4, 9, 20);
        LocalDateTime end = LocalDateTime.of(2025, 9, 4, 18, 10);

        Duration duration = Duration.between(start, end);

        int nHour = duration.toHoursPart();
        nHour--;
        int nMinute = duration.toMinutesPart();

        System.out.println("총 근무 시간 : " + nHour + "시간" + nMinute + "분");
    }
}
