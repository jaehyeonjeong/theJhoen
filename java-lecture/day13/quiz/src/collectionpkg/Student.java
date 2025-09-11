package collectionpkg;

import java.lang.Comparable;
import java.util.Comparator;

public class Student implements Comparator<Student> {
    private int age;            // 나이
    private int classNummber;   // 학급

    public Student(int age, int classNummber) {
        this.age = age;
        this.classNummber = classNummber;
    }

    @Override
    public int compare(Student o1, Student o2) {
        // o1의 학급이 o2의 학급보다 크다면 양수
        if(o1.classNummber > o2.classNummber) {
            return 1;
        }

        // o1의 학급이 o2의 학급과 같다면 0
        else if(o1.classNummber == o2.classNummber) {
            return 0;
        }

        //o1의 학급이 o2의 학급보다 작다면 음수
        else {
            return -1;
        }
    }

    //    @Override
//    public int compareTo(Student o) {
//        // 자기자신의 age가 o의 age보다 크다면 양수
//        if(this.age > o.age) {
//            return 1;
//        }
//
//        // 자기 자신의 age와 o의 age가 같다면 0
//        else if(this.age == o.age) {
//            return 0;
//        }
//
//        // 자기 자신의 age가 o의 age보다 작다면 음수
//        else {
//            return -1;
//        }
//    }
}
