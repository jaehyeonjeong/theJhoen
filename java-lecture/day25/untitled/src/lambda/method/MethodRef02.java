package lambda.method;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRef02 {
    public static void main(String[] args) {
        // 반환 (o) -> 입력 (x)
        Person person01 = new Person("kim");
        Person person02 = new Person("lee");
        Person person03 = new Person("park");

//        System.out.println(person01.introduce());
        Function<Person, String> function01 = (Person person) -> person.introduce();
        System.out.println(function01.apply(person01));
        System.out.println(function01.apply(person02));
        System.out.println(function01.apply(person03));

        // ::은
        Function<Person, String> function02 = Person::introduce;
        System.out.println(function02.apply(person01));
        System.out.println(function02.apply(person02));
        System.out.println(function02.apply(person03));
    }
}
