public class CCC extends BBB{
    public CCC() {
        super("정재현"); // 자식이 생성되면 부모를 호출할 수 있음
        System.out.println("CCC");
    }

    public CCC(String name) {
        super("정다현");
        this.name = name;
        System.out.println("CCC() -> 이름은 : " + name);
    }
}
