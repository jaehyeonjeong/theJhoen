package string.enumeration;

public enum Grade {
    BASIC("basic", 10),
    GOLD("gold",20),
    DIAMOND("diamond", 30);
    private final int percent;
    private final String name;

    Grade(String name, int percent) {
        this.percent = percent;
        this.name = name;
    }

    public int getPercent() {
        return percent;
    }

    public String getName() {
        return name;
    }

    public int discount(int price) {
        return price - price * percent / 100;
    }
}
