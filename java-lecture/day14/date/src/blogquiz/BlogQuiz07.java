package blogquiz;

import java.time.LocalDateTime;

public class BlogQuiz07 {
    //7.
    //두 구간 [s1, e1], [s2, e2](모두 LocalDateTime)이 주어질 때
    //
    //겹치는지 여부 겹친 시간(분) 을 반환하라.
    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.now();

        System.out.println(localDateTime1.isEqual(localDateTime2));
    }
}
