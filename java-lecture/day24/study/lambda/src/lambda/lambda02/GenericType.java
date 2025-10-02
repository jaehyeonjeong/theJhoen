package lambda.lambda02;

public class GenericType <T>{
    private T ex01;

    public GenericType(T ex01) {
        this.ex01 = ex01;
    }

    public T getEx01() {
        return ex01;
    }

    public void setEx01(T ex01) {
        this.ex01 = ex01;
    }
}
