package string.clazz;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassMain {
    // Class class가 있다.
    // class의 각종 메타 정보를 다룰 때 쓴다.
    // reflector 클래스에 정의된 메서드와 필드를 조회할 수 있다.
    // Class
//    Class clazz = String.class;
    public static void main(String[] args) throws ClassNotFoundException, Exception {
        Class clazz = Class.forName("java.lang.String");    // db 연결할 때 사용하는 방법

        Field[] fields = clazz.getDeclaredFields();

        for(Field filed : fields) {
            System.out.println(filed.getType() + " / " + filed.getName());
        }
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods) {
            System.out.println("Method : " + method);
        }
        // 자바의 라이브러리를 챙겨보면 된다.


        System.out.println("=========================================");
        // 아래와 같은 기법을 리플랙션 기법이라고 한다. 주로 DB에 쿼리할 때 사용
        Class helloClass = Class.forName("string.clazz.Hello");     // reflection
        // -> 클래스에 정의된 매서드 필드등을 조회하는 기법, 어노테이션 정보도 읽어서 기능을 수행하게 할 수 있다.
        Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();
        String result = hello.hello();
        System.out.println(result);
    }
}
