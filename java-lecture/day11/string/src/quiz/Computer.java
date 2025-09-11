package quiz;

public class Computer extends Player {
    // 기본 생성자가 있어야 함
    public Computer(String name) {
        super(name);
    }

    @Override
    public int turn() {
        return (int) (Math.random() * 3 + 1);
    }
}
