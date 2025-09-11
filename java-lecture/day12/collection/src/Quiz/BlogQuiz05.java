package Quiz;

import java.util.*;

public class BlogQuiz05 {
    public static void main(String[] args) {
        System.out.println("학생 이름, 학과, 학점, 평균을 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[1];

        List<Student> studentArrayList = new ArrayList<>();

        for (int i = 0; i < students.length; i++) {
            System.out.print(">>");
            // 입력을 , 으로 띄워도 String이 구분 될 수 있게 해야하는데...
            String string = scanner.nextLine();
            String[] strings = string.split(",");
//            System.out.println(Arrays.toString(strings));
            students[i] = new Student(strings[0], strings[1], strings[2], strings[3]);
            studentArrayList.add(students[i]);
        }

        for (Student student : students) {
            String string = student.showList();
            System.out.println(string);
        }

        while (true) {
            System.out.println("학생 이름 >>");
            String strInput = scanner.next();
            if (strInput.equals("그만")) {
                break;
            }
            Iterator<Student> studentIterator = studentArrayList.iterator();
            while (studentIterator.hasNext()) {
                if (studentIterator.next().getName().equals(strInput)) {
                    System.out.println("찾음");
                }
            }
        }

    }
}
