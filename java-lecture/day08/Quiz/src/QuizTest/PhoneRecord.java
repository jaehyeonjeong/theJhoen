package QuizTest;

public record PhoneRecord(String name, String tel) {
    // record는 자동으로 getter가 생성된다.

    // 뷸변객체에 많이 쓰인다.
    // 데이터 전달용으로 많이 쓰인다 (데이터베이스)
    // 이를 DTO(VO)라고 부른다.

    // 자바 16버전 이상부터 쓸 수 있다.(8에서 동작 안함)
    // legacy code 에서는 동작을 안하는 경우가 있다.
}
