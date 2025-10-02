package BlogQuiz;

public class ConverTest02 {
    public static void main(String[] args) {
//ratio는 1마일이 1.6Km이기때문에 1.6으로 설정
        Km2Mile toMile = new Km2Mile(1.6);
        toMile.run();
    }
}
