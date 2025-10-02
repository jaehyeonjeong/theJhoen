package quiz;

public class ConvertMain {
    public static void main(String[] args) {
        //ratio 1200원 환율 설정
        Converter toDollar = new Won2Dollar(1380);
        toDollar.run();
    }
}
