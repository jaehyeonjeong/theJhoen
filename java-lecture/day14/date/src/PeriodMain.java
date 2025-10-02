import java.time.LocalDate;
import java.time.Period;

public class PeriodMain {
    public static void main(String[] args) {
        // Period : 년월일 쪼개기
        // Duration : 시분초 쪼개기
        Period period = Period.ofDays(10);
        System.out.println(period);
        LocalDate currentDate = LocalDate.of(2030, 1, 1);
        LocalDate plusDate = currentDate.plus(period);
        System.out.println("현재 날짜 === " + currentDate);
        System.out.println("더한 날짜 === " + plusDate);

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = LocalDate.of(2025, 12, 25);
        Period between = Period.between(startDate, endDate);
        System.out.println(between.getDays() + " === " + between.getMonths());
    }
}
