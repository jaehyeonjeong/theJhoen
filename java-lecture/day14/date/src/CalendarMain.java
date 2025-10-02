import java.util.Calendar;

public class CalendarMain {
    public static void main(String[] args) {
        // 추상클래스 이므로 new 객체 할당을 할 수 없다.
        String monthArray[] = {"Jan", "Feb", "Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        int month = calendar.get(Calendar.MONTH);      // 1월 정월
        System.out.println(monthArray[month]);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        String days[] = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
        System.out.println(Calendar.SUNDAY);            // 1
        System.out.println(Calendar.MONDAY);            // 2
        System.out.println(Calendar.TUESDAY);           // 3
        System.out.println(Calendar.WEDNESDAY);
        System.out.println(Calendar.THURSDAY);

        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(days[weekDay]);

        // 4로 떨어지면 윤년, 2024 100으로 떨어지면 윤년아님 400으로 떨어지면 윤년 2000년
        // G(greenwich) M(mean) T(time) : 세계표준시, 세계평균시
        // UTC (원자시계 기준) : 협정세계시
    }
}
