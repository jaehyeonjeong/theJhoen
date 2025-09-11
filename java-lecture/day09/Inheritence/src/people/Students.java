package people;

public class Students extends Person{
    String grade;
    String department;

    public Students(String name) {
        super(name);
    }

    // 동적(run time을 의미한다.)
    // 오버 라이딩은 동적 바인딩(묶는다)을 한다.
    @Override // 키워드를 통해서 Override 여부를 판별할 수 있음
    public void introduce() {
        // 내용을 다르게 작성가능
        // 조건 : 이름과 매개변수 타입이 같아야한다.
        System.out.println("나는 학생입니다."); // 오버라이딩
    }

    public void study() {
        System.out.println("나는 학생이라 공부해야 합니다.");
    }
}
