public class BBB extends AAA {

    public BBB() {
        System.out.println("BBB");
    }

    public BBB(String name) {
        this.name = name;
        System.out.println("BBB() -> 이름은 : " + name);
    }
}
