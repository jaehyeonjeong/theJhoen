package string.time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class LocalDateMain {
    public static void main(String[] args) throws InterruptedException {
        LocalDateTime nowlocalDate = LocalDateTime.now();
        System.out.println(nowlocalDate);

        LocalDate now = LocalDate.now();
        System.out.println(now);

        LocalDate ofDate = LocalDate.of(2025,12, 31);
        System.out.println(ofDate);


        // LocalDate는 불변 객체
        LocalDate plusDays = now.plusDays(14);
        System.out.println(plusDays);


        // Calendar는 가변 객체 : 필요에 따라서 사용
        // Date는 절대 안됨. 가변성, 남발이 심하면 오류가 생김
        LocalDateTime now02 = LocalDateTime.now();
        System.out.println(now02);
        // 두 개로 분리가 가능
        System.out.println(now02.toLocalDate());
        System.out.println(now02.toLocalTime());

        LocalDate localDate = now02.toLocalDate();
        LocalTime localTime = now02.toLocalTime();
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2025, 9, 15,10, 10, 10);
        System.out.println(now02.isAfter(localDateTime1));      // 본 날짜가 해당 날짜 보다 이전인지
        System.out.println(now02.isBefore(localDateTime1));     // 본 날짜가 해당 날짜 보다 이후인지
        System.out.println(now02.isEqual(localDateTime1));     // 본 날짜와 해당 날짜가 같은지
        System.out.println(now02.equals(localDateTime1));     // 본 날짜와 해당 날짜가 같은지

        System.out.println(localDateTime.equals(localDateTime1));
//        OffsetDateTime offsetDateTime01 = localDateTime.atOffset(ZoneOffset.ofHours(0));
//        OffsetDateTime offsetDateTime02 = localDateTime.atOffset(ZoneOffset.ofHours(9));
        OffsetDateTime offsetDateTime01 = localDateTime.atOffset(ZoneOffset.UTC);
        OffsetDateTime offsetDateTime02 = offsetDateTime01.withOffsetSameInstant(ZoneOffset.ofHours(9));
        // UTC 기준으로는 isEquals로는 True가 출력

        System.out.println(offsetDateTime01);
        System.out.println(offsetDateTime02);
        System.out.println("equals = " + offsetDateTime02.equals(offsetDateTime01));        // 타입이 모두 같아야지만 true
        System.out.println("isEquals = " + offsetDateTime02.isEqual(offsetDateTime01));     // 이건 비교 대상이 시간이 같으면  true

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);     // 타임 존을 의미

        ZoneId seoul = ZoneId.of("Asia/Seoul");
        System.out.println(seoul);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        // Duration(시분초), Period(년월일) 시간 간격을 구할 때 사용
        // 시간의 간격을 구함
        // 2025.09.19 : 정확한 시간

        Period period = Period.ofDays(10);
        System.out.println("period = "+period); // 10일을 가리킴
        LocalDate now03 = LocalDate.of(2030, 1, 1);
        LocalDate plusDate = now03.plus(period);
        System.out.println(now03);
        System.out.println(plusDate);

        LocalDate startDate = LocalDate.of(2025, 9, 19);
        LocalDate endDate = LocalDate.of(2026, 2, 10);
        Period between = Period.between(startDate, endDate);
        System.out.println("between = " + between);
        System.out.println(between.getYears() + "년 " + between.getMonths() + "개월 " + between.getDays() + "일");
        System.out.println(ChronoUnit.DAYS.between(startDate, endDate));    // 총 일 수 출력(ChronoUnit 클래스를 이용)

        Duration duration = Duration.ofMinutes(30);
        System.out.println("duration = " + duration);
        LocalTime localTime1 = LocalTime.of(1, 0);
        System.out.println(localTime1.plus(duration));

        // 퀴즈 18:00 까지 남은 시간을 1초마다 한번씩 추력
        LocalTime endTime2 = LocalTime.of(18, 0, 0);


        while(true){
            LocalTime currenttime = LocalTime.now();
            Duration betweenTime = Duration.between(currenttime, endTime2);
            System.out.println("남은 시간 : " +
                    betweenTime.toHoursPart() + "시 "
                    + betweenTime.toMinutesPart() + "분 "
                    + betweenTime.toSecondsPart() + "초");
            Thread.sleep(1000);
        }
    }
}
