package blogquiz;

public class Student {
    private String name;
    private String department;
    private int year;
    private double avg;

    public Student(String name, String department, int year, double avg) {
        this.name = name;
        this.department = department;
        this.year = year;
        this.avg = avg;
    }

    public Student(String name, double avg) {
        this.name = name;
        this.avg = avg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", year=" + year +
                ", avg=" + avg +
                '}';
    }
}
