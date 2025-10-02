package blogquiz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class BlogQuiz04 {
    //4. Student 객체 리스트에서 점수가 85 이상인 학생들의 이름을 출력하세요.
    //
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 90),
            new Student("Bob", 80),
            new Student("Charlie", 85)
        );

        Stream<Student> stream = students.stream();

        stream
                .filter(x->x.score >= 85)
                .map(x->x.name)
                .forEach((Consumer<String>) System.out::println);
    }
}
