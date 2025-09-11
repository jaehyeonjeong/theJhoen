public class HumanMain {
    public static void main(String[] args) {
        Human human = new Human();
        // 클래스 타입을 Animal로 사용할 수 있지만 Human 클래스에 있는 메소드나 필드를 사용할 수 없다.
        //Animal human = new Human();
        // Animal 클래스 메소드
        human.eat();
        human.sleep();

        // Human 클래스 메소드
        human.work();
        human.study();
        human.sound();

        Cat cat = new Cat();
        cat.grooming();
        cat.sound();
    }
}
