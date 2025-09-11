package review;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class DateMain {
    public static void main(String[] args) {
         //자바에 날짜와 시간 관련된 것들 클래스들을 보면
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);  // 현재 시간

        LocalDate targetDate = LocalDate.of(2025, 12, 25);
        System.out.println(targetDate); // 조정 날짜

        // LocalDate는 한번 정해지면 변경할 수 없는 불변 객체이다.
        LocalDate plus10Day = localDate.plusDays(10);
        System.out.println(plus10Day);

        // Calendar객체는 사용하지 왠만하면 사용하지 않는 것이 좋다.
        // Calendar는 가변 객체이므로 사용에 주의성이 필요하다.
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDate localDate1 = localDateTime.toLocalDate();
        LocalTime localDate2 = localDateTime.toLocalTime();
        System.out.println(localDate2 + " / " + localDate1);
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate1, localDate2);
        System.out.println(localDateTime1);

        // Instant 1970.1.1. 00 : 00 EpochTime timestamp 전세계 공통 기준으로 지역에 따른 날짜/시간 데이터를 출력
        Instant instant = Instant.now();
        System.out.println("instant === " + instant);

        // Instant는 기준이 명확하기 때문에 타입등을 많이 신경써야한다.
        LocalDate xmas = LocalDate.of(2025, 12, 25);
        LocalDate now = LocalDate.now();
        long diff = xmas.toEpochDay() - now.toEpochDay();
        System.out.println("D-Day == " + diff);

        // Period, Duration : 시간차이
        Period period = Period.ofDays(111);         // 기간의 차이
        System.out.println("period === " + period);

        // Period를 이용하여 LocalDate에서 지원하는 plus()를 응용해서 날짜 수정도 가능
        LocalDate now02 = LocalDate.now();
        LocalDate plusDate111 = now02.plus(period); // plus 함수에서 받는 파라미터인 TemporalAmount는 Period와 같은 인터페이스를 상속받음
        System.out.println("현재 날짜에서 10일 더한 날짜 : " + plusDate111);
        System.out.println("현재 날짜 : " + now02);

        LocalDate newYear = LocalDate.of(2026, 1, 1);
        Period between = Period.between(now02, newYear);
        System.out.println(between.getYears() + " / " + between.getMonths() + " / " + between.getDays());

        long lbetween02 = newYear.toEpochDay() - now02.toEpochDay();
        long lbetween03 = ChronoUnit.DAYS.between(now02, newYear);
        System.out.println("새해까지 남은 일 수 : " + lbetween02);
        System.out.println("새해까지 남은 일 수 : " + lbetween03);

        // enum 상수(열거)
        // 1, 2, 3
//        Calendar calendar = Calendar.getInstance();
//        Calendar.AM;
        // 열거
        // Manager name
        Season season = Season.WINTER;  // enum을 사용하는 이유는 오타 방지 (type safe)
        System.out.println(season);     // 기본은 name을 반환
        System.out.println(season.ordinal()); // 숫자를 돌려 받고 싶을 떄는 ordinal을 사용
        System.out.println(season.name()); // 이름을 받고 싶을 때는 name을 사용
        System.out.println(season.getDisplayName()); // 생성자에 정의한 문자를 호출할 수 있다.
        System.out.println(season.getCode()); // int로 정의한 코드도 같이 볼 수 있다.
    }
}
