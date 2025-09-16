package blogquiz;

public class BlogQuiz02 {
    //다음 코드는, 주어진 숫자(예: 10)를 특정 단위(예: "kg")로 출력하는 간단한 메서드를 작성한
    //예시이다. 숫자와 단위를 나누고 재사용 가능한 메서드를 사용하도록 코드를 수정해라.
    // 숫자는 int, 단위는 String
    @FunctionalInterface
    public interface M2Before {
        void output(int weight, String unit);
    }

    public static void main(String[] args) {
        M2Before m2Before = (weight, unit) -> System.out.println("무게 : " + unit);

        m2Before.output(200, "kg");
    }
}
