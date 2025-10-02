import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class DurationMain {
    public static void main(String[] args) {
        Duration duration = Duration.ofMinutes(30);
        System.out.println(duration);

        LocalTime now = LocalTime.now();
        LocalTime plus30Min = now.plus(duration);
        System.out.println(plus30Min);

        // 간단 퀴즈
        // 09:30 ~ 18:00
        LocalTime startTime = LocalTime.of(9, 30, 0);
        LocalTime endTime = LocalTime.of(17, 50, 0);
        Duration studyTime = Duration.between(startTime, endTime);
        System.out.println("총 시간 차이 : " + studyTime.toHours() + "시간 " + studyTime.toMinutesPart() + "분");


        // 간단 퀴즈
        // 현재 시간에서 글쓴 시간 3개 10분전, 30분전, 5시간 전에 글을 썻다고 가정
        // 10분전 글은 방금전, 30분전은 30분전, 1시간 이후는 시간만 출력

        LocalTime localTime = LocalTime.now();

        LocalTime localTime10Min = localTime.plusMinutes(-4);
        LocalTime localTime30Min = localTime.plusMinutes(-29);
        LocalTime localTime1Hour = localTime.plusHours(-2);

        System.out.println(localTime10Min);
        System.out.println(localTime30Min);
        System.out.println(localTime1Hour);

        Duration[] logTime = new Duration[3];
        // between에서는 작은 시간, 큰 시간으로 파라미터를 설정해야 값이 양수로 나온다.
        logTime[0] = Duration.between(localTime10Min, localTime);
        logTime[1] = Duration.between(localTime30Min, localTime);
        logTime[2] = Duration.between(localTime1Hour, localTime);

        for (int i = 0; i < 3; i++) {
            long llogTime = logTime[i].toMinutes();
//            System.out.println(llogTime);

            if (llogTime <= 10) {
                System.out.println("방금전");
            } else if (llogTime <= 59) {
                System.out.println(llogTime + "분전");
            } else {
                System.out.println(logTime[i].toHours() + "시간 전");
            }
        }


    }
}
