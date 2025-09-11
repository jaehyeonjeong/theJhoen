package BlogQuiz;

public class ConvertTest {
    public static void main(String[] args) {
        //ratio 1200원 환율 설정
        Won2Dollar toDollar = new Won2Dollar(1200);
        toDollar.run();
    }
}
