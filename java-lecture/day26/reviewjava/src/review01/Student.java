package review01;

public class Student extends Animal{
    // class 만드는 이유
    // private로 하여금 외부에서 사용하지 못하도록 하는 캡슐화 진행

    // 1. private       :  바로 접근하지 않게함.
    // 2. default       : 같은 패키지 내에서 호출 허용
    // 3. protected     : 상속을 받으면 패키지 달라도 호출을 허용
    // 4. public
    private String name;
    private int number;
    private String nickName01;
    private int grade;
    private int age;

    public Student(String name01, int number01, String nickName01, int grade, int age) {
        this.name = name01;
        this.number = number01;
        this.nickName01 = nickName01;
        this.grade = grade;
        this.age = age;
    }

    // 내가 임의의 생성자를 만들면 기본생성자가 JVM에서 자동으로 생성됨.
    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getNickName01() {
        return nickName01;
    }

    public void setNickName01(String nickName01) {
        this.nickName01 = nickName01;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", nickName01='" + nickName01 + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                '}';
    }

    @Override
    public void sound() {

    }

    @Override
    public void move() {

    }
}
