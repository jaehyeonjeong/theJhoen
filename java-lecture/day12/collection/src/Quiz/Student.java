package Quiz;

public class Student {
    private String name;
    private String subject;
    private String number;
    private String average;

    public Student(String name, String subject, String number, String average) {
        this.name = name;
        this.subject = subject;
        this.number = number;
        this.average = average;
    }

    public String showList() {
        return "------------------------------" + '\n' +
                "이름: " + name + '\n' +
                "학과: " + subject + '\n' +
                "학번: " + number + '\n' +
                "평균: " + average + '\n';
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return """
                %s, %s, %s, %s"""
                .formatted(name, subject, number, average);
    }
}
