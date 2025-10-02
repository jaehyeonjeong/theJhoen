package blogquiz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlogQuiz09 {
    static class Student {
        String name;
        int ban;
        int score;

        Student(String name, int ban, int score) {
            this.name = name;
            this.ban = ban;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        // 9. Student 객체 리스트에서 각 ban(반)별로 평균 점수를 구하세요.
        List<Student> students = Arrays.asList(
                new Student("Alice", 1, 90),
                new Student("Bob", 1, 80),
                new Student("Charlie", 2, 85),
                new Student("David", 2, 95)
        );

        System.out.println(banAverage(students, 1));
        System.out.println(banAverage(students, 2));
    }

    public static String banAverage(List<Student> students, int ban) {
        Stream<Student> stream01 = students.stream();
        Stream<Student> stream02 = students.stream();
        // Stream 배열을 시도해 봤는데 잘 되질 않네

        // 이거는 세영이가 알려준 방식 응용
//        double avg = stream.filter(x->x.ban == ban)
//                .collect(Collectors.averagingDouble(s -> s.score));

        // 내가 터득한 방식
        int newAvg = stream01.filter(x->x.ban == ban)
                .map(x->x.score)
                .reduce(0, Integer::sum);
        long count = stream02.filter(x->x.ban == ban).count();
        newAvg = newAvg/(int)count;

//
//        double avg = stream.filter(x->x.ban == ban)
//                .collect(Collectors.);

        return """ 
                %d반의 평균 점수 : %d""".formatted(ban, newAvg);
//        return """
//                %d반의 평균 점수 : %.2f""".formatted(ban, avg);
    }
}
