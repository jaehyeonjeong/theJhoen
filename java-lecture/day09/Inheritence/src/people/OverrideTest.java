package people;

public class OverrideTest {
    public static void main(String[] args) {

        // 오버로딩 : 컴파일 시점 바인딩 -> 정적 바인딩
        // 오버라이딩 : 런타임 시점 바인딩 -> 동적 바인딩
        Person person01 = new Person("정재현");
        Person person02 = new Students("정다현");

        person01.introduce();
        person02.introduce(); // 동적 바인딩

    }
}
