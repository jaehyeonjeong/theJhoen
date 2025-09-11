package blogquiz;

import java.time.*;

public class BlogQuiz01 {
    //    LocalDateTime postTime과 LocalDateTime now가 주어질 때,
//30분 미만: "방금 전"
//            1시간 이상 24시간 미만: "n시간 전"
//            1일 이상 7일 미만: "n일 전"
//            7일 이상은 그냥 쓴 날짜와 시간을 출력하시오.
    public static void main(String[] args) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime postTime = nowDateTime.plusDays(-6).plusHours(-24);

        System.out.println(nowDateTime);
        System.out.println(postTime);

        Duration duration = Duration.between(postTime, nowDateTime);
        Period period = Period.between(LocalDate.from(postTime), LocalDate.from(nowDateTime));
        System.out.println(duration);
        System.out.println(period);
        int nHour = duration.toHoursPart(); // 0 ~ 23
        int nDay = period.getDays(); // 1

        boolean isContinue = false;

        // 현재 Local 시간보다 큰지 아닌지도 확인할 필요가 있다.
        if(nDay > 0 && nHour > LocalTime.from(nowDateTime).getHour()) {
            // 해당조건에 부합하면 하루를 차감
            nDay -= 1;
        }

        System.out.println("nHour = " + nHour);
        System.out.println("nDay = " + nDay);

        if(nDay > 0) {
            // 1일 쨰 되는걸 뜻함
            if(nDay < 7) {
                System.out.println(nDay + "일전");
            }
            else {
                System.out.println(postTime);
            }
        }
        else {
            // 1일 이상 24시간 미만
            System.out.println(nHour + "시간 전");
        }



        // 내가 원하는 바는 아니게 됨
//        Period between = Period.between(LocalDate.from(postTime), LocalDate.from(nowDateTime));
//        System.out.println(between.getDays());
//        int nDays = between.getDays();
//        if (nDays > 0) {
//            if (nDays < 7) {
//                System.out.println(nDays + "일전");
//            }
//        } else {
//            Duration durationTime = Duration.between(LocalTime.from(postTime), LocalTime.from(nowDateTime));
//            System.out.println(durationTime.toHours() + "시간 전");
//        }


    }
}
