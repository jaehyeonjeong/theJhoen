import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime ofNow = LocalDateTime.of(2025, 9, 4, 18, 0, 1);
        System.out.println(ofNow);
        LocalDate localDate = now.toLocalDate();
        LocalTime localTime = now.toLocalTime();
        System.out.println(localDate);      // 날짜
        System.out.println(localTime);      // 시간분리 가능

        LocalDateTime plusDay = now.plusDays(10);   // 현재날짜에 10일을 더함
        System.out.println(plusDay.isBefore(now));      // now 보다 plusDay가 뒤에 있는가? false
        System.out.println(plusDay.isAfter(now));       // now 보다 plusDay가 앞에 있는다? true
        System.out.println(plusDay.isEqual(now));       // now 와 plusDay가 일치하는가? false
        System.out.println(plusDay);
    }
}
