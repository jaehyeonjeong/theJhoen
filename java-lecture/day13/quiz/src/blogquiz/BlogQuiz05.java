package blogquiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BlogQuiz05 {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("정재현", "JAVA", 2, 2.5));
        studentList.add(new Student("정다현", "JAVA", 1, 3.5));
        studentList.add(new Student("정해영", "JAVA", 3, 1.5));
        studentList.add(new Student("정민희", "JAVA", 3, 1.0));

        for (Student student : studentList) {
            System.out.println(student);
        }

        Scanner scanner = new Scanner(System.in);
    }
}
