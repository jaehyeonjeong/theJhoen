import java.util.Optional;

public class OptinalGetMain {
    public static void main(String[] args) {
        Optional<String> optionalValue = Optional.of("hello");
        Optional<String> optionalEmpty = Optional.empty();

        // 출력된다고 데이터 타입이 String은 아님
        System.out.println(optionalValue);
        System.out.println(optionalEmpty);

        // 값 boolean 판별
        System.out.println("optionalValue.isPresent() : " + optionalValue.isPresent());
        System.out.println("optionalEmpty.isPresent() : " + optionalEmpty.isPresent());

        // null boolean 판별
        System.out.println("optionalValue.isEmpty() : " + optionalValue.isEmpty());
        System.out.println("optionalEmpty.isEmpty() : " + optionalEmpty.isEmpty());


        // get은 남발해서는 안된다.
        System.out.println("optionalValue.get()() : " + optionalValue.get());
//        System.out.println("optionalEmpty.get()() : " + optionalEmpty.get());


        // orElse로 출력 가능
        System.out.println("optionalValue.orElse() : " + optionalValue.orElse("기본값"));
        System.out.println("optionalEmpty.orElse() : " + optionalEmpty.orElse("기본값"));

        // orElseGet (Supplier Function)
        System.out.println("optionalValue.orElseGet() : " + optionalValue.orElseGet(()-> {
            // 값을 받기 전에 뭔가를 해야할 때 필요
            System.out.println("람다 실행 후 optionalValue");
            return "new value";
        }));
        System.out.println("optionalEmpty.orElseGet() : " + optionalEmpty.orElseGet(()-> {
            System.out.println("람다 실행 후 optionalEmpty ");
            return "new value";
        }));
//        System.out.println("optionalEmpty.orElseGet() : " + optionalEmpty.orElseGet("기본값"));

        // 예외를 던지는 방법
        String value03 = optionalValue.orElseThrow(()->new RuntimeException("값이 없습니다."));
        System.out.println(value03);


        try {
            String value04 = optionalEmpty.orElseThrow(()->new RuntimeException("값이 없습니다."));
            System.out.println(value04);
        } catch (Exception e) {
            System.out.println("예외가 발생");
            System.out.println();
        }


        String value06 = optionalEmpty.orElseThrow(()->new RuntimeException("값이 존재하지 않습니다."));
        System.out.println(value06);

        // NPE Null Point Exception 문제 때문에 등장한게 optional이다.
    }

}
