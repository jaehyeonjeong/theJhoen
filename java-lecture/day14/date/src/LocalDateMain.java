import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate);    //날짜 까지만 사용할 수 있음.
        LocalDate ofDate = LocalDate.of(2025, 12, 25);
        System.out.println(ofDate);
        System.out.println(ofDate.getClass());

        System.out.println("nowDate.getYear() ==== " + nowDate.getYear());              // 2025
        System.out.println("nowDate.getMonth() ==== " + nowDate.getMonth());
        System.out.println("nowDate.getMonthValue()) ==== " + nowDate.getMonthValue());
        System.out.println("nowDate.getDayOfYear() ==== " + nowDate.getDayOfYear());
        System.out.println("nowDate.getDayOfWeek() ==== " + nowDate.getDayOfWeek());
        System.out.println("nowDate.getDayOfMonth() ==== " + nowDate.getDayOfMonth());


        System.out.println("nowDate.isLeapYear() ==== " + nowDate.isLeapYear()); // 윤년인지 아닌지 true, false로 출력

        LocalDate plus10Day = nowDate.plusDays(10); // 불변을 가변객체로
        System.out.println(ofDate.plusDays(10));
        System.out.println(plus10Day);
        System.out.println(nowDate.getClass());

    }
}
