package blogquiz.blog4;

import java.time.Duration;
import java.time.LocalTime;

public class BlogQuiz04 {
    public static void main(String[] args) {
        LocalTime afterTime = LocalTime.of(9, 8, 11);
        LocalTime beforeTime = LocalTime.of(9, 8, 11);

        //Duration duration = Duration.between(afterTime, beforeTime);

        RateLimitExceeded rateLimitExceeded = new RateLimitExceeded();

        for(int i = 0; i < 3; i++) {
            try {
                rateLimitExceeded.countFunc(afterTime, beforeTime);
            }
            catch (RateLimitExceededException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
