package lambda.method;

import java.util.function.Supplier;

public class MethodRef01 {
    public static void main(String[] args) {
        // 반환 (o) -> 입력 (x)
        Supplier<String> staticMethod01 = () -> Person.greeting();
        System.out.println("staticMethod01.get() : " + staticMethod01.get());

        // 위와 같은 동작을 함.
        Supplier<String> staticMethod02 = Person::greeting;
        System.out.println("staticMethod02.get() : " + staticMethod02.get());

        // ::을 쓰는 순간은 즉시 호출 명령어를 하기 떄문에 ()를 넣어주면 안됨.
        Person person = new Person("JJH");
        Supplier<String> instanceMethod01= () -> person.introduce();
        System.out.println("instanceMethod02.get() : " + instanceMethod01.get());

        Supplier<String> instanceMethod02 = person::introduce;
        System.out.println("instanceMethod02.get() : " + instanceMethod02.get());

        //
        Supplier<Person> personSupplier01 = ()->new Person("newPerson");
        Supplier<Person> personSupplier02 = Person::new;

        System.out.println("personSupplier01.get() : " + personSupplier01.get());
        System.out.println("personSupplier02.get() : " + personSupplier02.get());

        System.out.println("personSupplier01.get() : " + personSupplier01.get().getName());
        System.out.println("personSupplier02.get() : " + personSupplier02.get().getName());
    }
}
