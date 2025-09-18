package blogquiz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class BlogQuiz03 {
    //3.
    //Student 객체 리스트에서 이름이 "A"로 시작하는 학생들의 이름을 출력하세요.
    //
    //List<Student> students = Arrays.asList(
    //    new Student("Alice", 90),
    //    new Student("Bob", 80),
    //    new Student("Anna", 85)
    //);
    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) {
        // 스트림으로 하는 방법으로 빠르게 진행
        List<Student> students = Arrays.asList(
            new Student("Alice", 90),
            new Student("Bob", 80),
            new Student("Anna", 85)
        );

        // Foreach를 까먹고 있었자나
        Stream<Student> stream = students.stream();
        stream.map(student->student.name)
                .filter(x->x.startsWith("A"))
                .forEach(System.out::println);
    }
}
