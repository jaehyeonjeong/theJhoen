package blogquiz;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

public class BlogQuiz06 {
    //6.
    //오늘부터 해당 달의 말일까지 남은 평일(월~금) 개수를 구하라. (공휴일 제외)
    public static void main(String[] args) {
        // 캘린더를 썻어야 했네
        Calendar calendar = Calendar.getInstance();
        // 이번달 연도와 월
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        int month = calendar.get(Calendar.MONTH);      // 1월 정월
        System.out.println(month);      //  + 1 해줘야 함.

        // 이번달의 첫 날로 설정
        calendar.set(year, month, 1);

        // 이번달의 총 일수 저장
        int maximumDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        String days[] = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};

        int weekendCount = 0;
        for(int day = 1; day <= maximumDay; day++) {
            // 반복문에서 새롭게 일 수를 set해주어야 함.
            calendar.set(year, month, day);
            // 디버그 해서 알 수 있듯이 int dayOfWeek는 받은 해당 연월일을 따져서 그것이 몇요일인지 확인
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            // 토요일 : 7, 일요일 : 1
            if(dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                weekendCount++;
            }
        }

        int nResult = maximumDay - weekendCount;
        System.out.println(weekendCount);

        System.out.println("""
                %d월 달 주말을 뺀 총 일수 : %d"""
                .formatted(month + 1, nResult));


    }
}
