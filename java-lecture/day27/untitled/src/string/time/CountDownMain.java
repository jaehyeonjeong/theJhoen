package string.time;

import java.time.Duration;
import java.time.LocalTime;

public class CountDownMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new CountDownTask(), "CountDown");
        thread.start();
    }

    static class CountDownTask implements Runnable {

        @Override
        public void run() {
            // 퀴즈 18:00 까지 남은 시간을 1초마다 한번씩 추력
            LocalTime endTime2 = LocalTime.of(17, 50, 0);
            try {
                while(true) {
                    LocalTime currentTime = LocalTime.now();
                    Duration betweenTime = Duration.between(currentTime, endTime2);
                    // duration은 second와 nanoSeconds만 있다.
                    // 만약 버전이 높다면 to---Part() 메서드를 사용할 수 있다.
                    System.out.println("남은 시간 : " +
                            betweenTime.toHoursPart() + "시 "
                            + betweenTime.toMinutesPart() + "분 "
                            + betweenTime.toSecondsPart() + "초");
//                    System.out.println();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("종료되었습니다.");
            }
        }
    }
}


