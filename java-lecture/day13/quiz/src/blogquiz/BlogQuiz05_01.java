package blogquiz;

import java.util.*;

public class BlogQuiz05_01 {
    public static void main(String[] args) {
        Map<String, Student> studentMap = new HashMap<>();

        studentMap.put("정재현", new Student("정재현", "JAVA", 2, 2.5));
        studentMap.put("정다현", new Student("정다현", "JAVA", 1, 3.5));
        studentMap.put("정해영", new Student("정해영", "JAVA", 3, 1.5));
        studentMap.put("정민희", new Student("정민희", "JAVA", 3, 1.0));
        // map 컬렉션은 데이터를 입력할 때 put으로 넣는다.

        // 첫번쨰 방법
        Iterator<String> iterator = studentMap.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(studentMap.get(iterator.next()));
        }
        System.out.println();
        // 두번쨰 방법
        Iterator<Student> studentIterator = studentMap.values().iterator();
        while (studentIterator.hasNext()){
            System.out.println(studentIterator.next());
        }
        System.out.println();
        // 세번째 방법
        Iterator<Map.Entry<String, Student>> entryIterator = studentMap.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<String, Student> entry = entryIterator.next();
            System.out.println(entry.getKey() + " / " + entry.getValue());
        }

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String name = scanner.nextLine();

            if(name.equals("그만")) break;
            Student student = studentMap.get(name);
            System.out.println(student);
        }
    }
}
