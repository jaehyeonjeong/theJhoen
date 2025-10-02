package blogquiz.blog3;

public class CsvFormat {
    private String name;
    private Integer age;
    private String city;

    public CsvFormat() {

    }

    public CsvFormat(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public CsvFormat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public CsvFormat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void showAll() throws CsvFormatException {
        if (name == null || age == null || city == null) {
            System.out.print(getName() + "님 ");
            throw new CsvFormatException("3가지 필드를 만들지 않았습니다. 다시 만드십시오.");
        }
        else {
            System.out.printf("""
                    이름 : %s, 나이 : %d, 도시 : %s%n""", name, age, city);
        }
    }
}
