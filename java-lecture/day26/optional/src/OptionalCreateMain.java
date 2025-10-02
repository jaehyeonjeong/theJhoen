import java.util.Optional;

public class OptionalCreateMain {
    public static void main(String[] args) {
        String noneNullValue = "Hello Optional";
        // of 는 null이 아니라는 게 확실할 때
        Optional<String> optional01 = Optional.of(noneNullValue);
        System.out.println("optional01 : " + optional01.orElse("NULL"));

        // ofNullable() 값이 null일 수도 있다.
        Optional<String> optional02 = Optional.ofNullable("Hello");
        Optional<String> optional03 = Optional.ofNullable(null);
        System.out.println("optional02 : " + optional02);
        System.out.println("optional03 : " + optional03);

        Optional<String> optional04 = Optional.empty();
        System.out.println("optional04 : " + optional04);
    }
}
