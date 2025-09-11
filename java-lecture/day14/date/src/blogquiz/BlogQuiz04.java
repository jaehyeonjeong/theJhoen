package blogquiz;

import java.time.LocalDate;
import java.time.Period;

public class BlogQuiz04 {
    //4.
    //생일 LocalDate birth가 주어질 때,
    //만 나이(오늘 기준)
    //다음 생일까지 남은 Period(년/월/일) 을 구하라.
    public static void main(String[] args) {
        LocalDate birth = LocalDate.of(1997, 3, 6);
        LocalDate toAge = LocalDate.now();

        Period period = Period.between(birth, toAge);
        System.out.println(period);
        System.out.println("만나이 : " + period.getYears());
        int nMonth = period.getMonths();
        int nDay = period.getDays();
        System.out.println("다음 생일 까지 남은 월/일 : " + nMonth + "월 / " + nDay + "일 ");
    }
}
