package lambda.method;

import java.util.function.BiFunction;

public class MethodRef03 {
    public static void main(String[] args) {
        // 반환 (o) -> 입력 (x)
        Person person01 = new Person("kim");
        Person person02 = new Person("lee");
        Person person03 = new Person("park");

        BiFunction<Person, Integer, String> biFunction01 = (Person person, Integer number)
                -> person.introduceWithNumber(number);
        System.out.println(biFunction01.apply(person01, 30));
        System.out.println(biFunction01.apply(person02, 25));
        System.out.println(biFunction01.apply(person03, 30));
        System.out.println();

        // 매개변수가 있어도 ()를 쓰지 않아도 됨
        BiFunction<Person, Integer, String> biFunction02 = Person::introduceWithNumber;
        System.out.println(biFunction02.apply(person01, 30));
        System.out.println(biFunction02.apply(person02, 25));
        System.out.println(biFunction02.apply(person03, 30));
    }
}
