package ex02;

public class Container <T>{
    private T item;

//    public T getItem() {
//        return item;
//    }
//
//    public void setItem(T item) {
//        this.item = item;
//    }
    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public boolean isEmpty() {
        // 참조의 기본타입은 null이기 때문에 null이면 true 아니면 false로 출력
        // 기본 타입이 null인것을 항시 기억하기
        if(this.item == null) return true;
        else return false;
    }
}
