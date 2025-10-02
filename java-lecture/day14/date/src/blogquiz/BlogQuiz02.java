package blogquiz;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class BlogQuiz02 {
//    2.
//    LocalDateTime deadline 기준으로
//    지금이 마감 전이면 "D-n"(일 단위 내림, 0이면 "D-Day")
//    마감 지났으면 "D+ n" 을 반환하라. (분·시간 단위 무시, 날짜 기준)

    public static void main(String[] args) {
        // 마감 시간
        LocalDateTime deadline = LocalDateTime.of(2025, 10, 3, 18, 0, 0);

        // 현재 시간
        LocalDateTime currentTime = LocalDateTime.now();

        // 마감이 지난 경우 +해야 하기 떄문에 deadLine이 더 적은 시간을 가지기 때문에 deadline이 첫번째 파라미터로 간다.
        //Period period = Period.between(LocalDate.from(deadline), LocalDate.from(currentTime));

        LocalDate localDate1 = deadline.toLocalDate();
        LocalDate localDate2 = currentTime.toLocalDate();

        long lDays = ChronoUnit.DAYS.between(localDate1, localDate2);
       ;
//        Period period = Period.between(localDate1, localDate2);
//        long lDays = period.getDays();

        System.out.println(lDays);
        if(lDays > 0) {
            System.out.println("D+" + lDays);
        } else if(lDays < 0 ){
            System.out.println("D" + lDays);
        } else {
            System.out.println("D-Day");
        }

    }
}
