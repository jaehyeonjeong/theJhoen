package blogquiz.blog4;

import java.time.Duration;
import java.time.LocalTime;

public class RateLimitExceeded {
    // 호출 제한 초과라는게 무슨의미 인고...
    // 1초(1000ms) 에 최대 3회 호출..
    private int count;

    public RateLimitExceeded() {
    }

    public void countFunc(LocalTime after, LocalTime before) {
        count++;
        response(after, before);
    }


    // 시간 제한인 Duration을 이용하여 1초안에 데이터가 응답하는 구조를 만들어야 하는것인지.
    public void response(LocalTime after, LocalTime before) {
        Duration duration = Duration.between(after, before);
        if(duration.toSecondsPart() <= 1 && count >= 4) {
            throw new RateLimitExceededException("카운트 또는 1초이네 카운트 초과");
        }
        else{
            System.out.println(this.count);
        }
    }
}
