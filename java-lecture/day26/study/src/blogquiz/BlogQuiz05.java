package blogquiz;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class BlogQuiz05 {
    //5. Student 객체 리스트에서 가장 높은 점수를 구하세요.

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 90),
            new Student("Bob", 80),
            new Student("Charlie", 85)
        );

        Stream<Student> stream = students.stream();
        Optional<Integer> maxScore = stream.map(x->x.score)
                .max(Integer::compareTo);
        System.out.println("최고 점수 : " + maxScore.get());
    }
}
