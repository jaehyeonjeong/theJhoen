package blogquiz;

import java.util.*;

public class BlogQuiz07 {
    public static void main(String[] args) {
        Map<String, Student> studentMap = new TreeMap<>(Comparator.reverseOrder());
        // LinkedHashMap은 입력한 순서대로 정렬
        // TreeMap은 키 사전 순서대로 나열된다. (기본은 오름차순으로 정렬),
        // TreeMap에서 만약 내림차순으로 변경하기 위해서는 ()안에 Comparator.reverseOrder()를 넣어줌
        // HashMap을 사용해도 지장없음.
        studentMap.put("적당히", new Student("적당히", 3.1));
        studentMap.put("나탈락", new Student("나탈락", 2.4));
        studentMap.put("최고조", new Student("최고조", 4.3));
        studentMap.put("상당히", new Student("상당히", 3.9));
        studentMap.put("고길동", new Student("고길동", 4.4));
        studentMap.put("고득점", new Student("고득점", 4.0));

        double scholarship = 3.2;
        Iterator<String> stringIterator = studentMap.keySet().iterator();
        while(stringIterator.hasNext()) {
            Student student = studentMap.get(stringIterator.next()); // student
            if (student.getAvg() > scholarship) {
                System.out.print(student.getName() + " / ");
            }
        }

        System.out.println();
        // String s -> Key, KeySet중에서 Student 객체의 s를 받게 함
        for (String s : studentMap.keySet()) {
            Student student = studentMap.get(s); // student
            if (student.getAvg() > scholarship) {
                System.out.print(student.getName() + " / ");
            }
        }

        System.out.println();
        for(Map.Entry<String, Student> entry : studentMap.entrySet()) {
            Student student = studentMap.get(entry.getKey());
            if(student.getAvg() > scholarship) {
                System.out.print(student.getName() + "/ ");
            }
        }
    }
}
