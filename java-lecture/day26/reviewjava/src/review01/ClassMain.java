package review01;

public class ClassMain {
    static final int RATIO_STATE = 10;

    public static void main(String[] args) {
        Student student01 = new Student();
        student01.setName("정재현");
        student01.setNumber(2);
        student01.setNickName01("피콜로");
        student01.setGrade(1);
        student01.setAge(29);

        // 클래스를 사용하는 이유는 여러 타입을 묶어서 호출할 수 있기 때문
        System.out.println(student01);

        Student student02 = new Student("정해영", 4, "엄마", 2, 59);
        System.out.println(student02);

        final int data;
        data = 20;

//        data = 120; // final로 선언한 변수는 더 이상 참조 X

    }
}
