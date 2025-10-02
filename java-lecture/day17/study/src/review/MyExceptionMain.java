package review;

public class MyExceptionMain {
    public static void main(String[] args) {
        // main에서는 throw로 던질 수 없기 때문에 try catch로 처리해야 한디.
        try {
            checkAge(16);
        } catch (MyException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void checkAge(int age) throws MyException {
        if(age <18) {
            throw new MyException("미성년자는 출입할 수 없습니다.");
        }
        System.out.println("입장하세요.");
    }
}
