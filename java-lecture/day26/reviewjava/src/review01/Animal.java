package review01;

// abstract는 강제성을 부여
public abstract class Animal {
    // 아래와 같이 abstract로 구현이 다되어있는 것을 순수 추상 클래스라고 함.
    public abstract void sound();
    public void move(){
        System.out.println("동물이 이동합니다.");
    };
}
