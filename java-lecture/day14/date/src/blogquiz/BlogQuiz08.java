package blogquiz;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class BlogQuiz08 {
    public static void main(String[] args) {
        //8.
        //LocalDateTime t를 가까운 15분 단위로 반올림한 결과를 반환하라.
        //예) 10:07 → 10:00, 10:08 → 10:15
        // 규칙 1. 0 ~ 15 수 중 0이상 7이하는 0으로 8이상 15이하는 15,
        // 규칙 2. 15 ~ 30 수 중 16이상 22이하는 15, 23이상 30이하는 30,
        // 규칙 3. 30 ~ 45 수 중 31이상 37이하는 30, 38이상 45이하는 45,
        // 규칙 4. 45 ~ 00 수 중 46이상 52이하는 45, 53이상 59이하는 00


        LocalDateTime localDateTime = LocalDateTime.of(2025, 9, 4, 23, 17, 0);
        System.out.println("getMinute = " + localDateTime.getMinute());
        long lMinutes = localDateTime.getMinute();
        // 규칙 1부터 진행
        if( lMinutes <= 7) { //0이상 7이하는 0
            localDateTime = localDateTime.minusMinutes(lMinutes);
        } else if (lMinutes <= 15) { //8이상 15이하는 15,
            localDateTime = localDateTime.plusMinutes(15 - lMinutes);
        }
        // 규칙 2
        else if (lMinutes <= 22){ //16이상 22이하는 15
            localDateTime = localDateTime.minusMinutes(lMinutes - 15);  // 이전 시간으로 수렴하는 경우엔 목표 시간 만큼 뺀 값에서 minus
        }
        else if (lMinutes <= 30) { //23이상 30이하는 30
            localDateTime = localDateTime.plusMinutes(30 - lMinutes);  // 이후 시간으로 수렴하는 경우에는 목표시간 - 뺀시간 + 현재시간 = 목표시간
        }

        // 규칙 2
        else if (lMinutes <= 37){ //31이상 37이하는 30
            localDateTime = localDateTime.minusMinutes(lMinutes - 30);
        }
        else if ( lMinutes <= 45) { // 38이상 45이하는 45
            localDateTime = localDateTime.plusMinutes(45 - lMinutes);
        }

        // 규칙 2
        else if ( lMinutes <= 52){ // 46이상 52이하는 45
            localDateTime = localDateTime.minusMinutes(lMinutes - 45);
        }
        else  { //53이상 59이하는 00
            localDateTime = localDateTime.plusMinutes(60 - lMinutes);
            //localDateTime = localDateTime.plusHours(1); // 시간 추가
        }

        System.out.println(localDateTime);
    }
}
