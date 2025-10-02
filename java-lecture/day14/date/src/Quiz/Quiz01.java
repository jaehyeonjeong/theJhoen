package Quiz;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Quiz01 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDate myLocalDate  = LocalDate.of(1997, 3, 6);

        Period between = Period.between(myLocalDate, LocalDate.from(localDateTime));

        System.out.println("생년월일 간격은 : " + between.getYears() + "년 " + between.getMonths() + "월 " +
                between.getDays() + "일");

        System.out.println(between.toTotalMonths() + "개월생");

    }
}
