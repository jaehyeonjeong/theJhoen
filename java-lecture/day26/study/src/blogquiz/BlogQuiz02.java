package blogquiz;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlogQuiz02 {
    //2. Student 객체 리스트에서 학생들의 평균 점수를 구하세요.
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

        // 1. 일반적으로 평균을 구하는 방법
        int sum = 0;
        for(Student student : students) {
            sum += student.score;
        }
        System.out.println("첫 번째 방법 평균 : " + sum / students.size());

        // 2. 임의의 정적 메소드 파라미터에 Function 함수를 사용하는 방법
        System.out.println("두 번째 방법 평균 : " + filter(students, Double::sum));

        // 3. Stream으로 구하는 방법
        Stream<Student> stream = students.stream();
        int avg = stream.map(student->student.score)
                .reduce(0, Integer::sum);
        System.out.println("세 번쨰 방법 평균 : " + avg / students.size());

        // 4. Collectors.averagingInt
        double average = students.stream()
                .collect(Collectors.averagingInt(s -> s.score));

        System.out.println("평균 점수: " + average); // 85.

    }

    public static Double filter (List<Student> students, BinaryOperator<Double> function) {
        double total = 0;
        for(Student student : students) {
//            System.out.println("sum = " + sum + ", score = " + (double)student.score);
            total += function.apply(0.0, (double)student.score);
        }

//        System.out.println("total : " + total);
        
        return total / students.size();
    }
}
