package people;

public class IntstanceofTest {
//    static void printInfo(Students person) {
//        System.out.println("학생입니다.");
//    }
//    static void printInfo(Researcher person) {
//        System.out.println("연구자 입니다.");
//    }
//    static void printInfo(Professor person) {
//        System.out.println("교수입니다.");
//    }
    static void printInfo(Person person) {
        //System.out.println("사람 입니다.");
        if(person instanceof Professor) {
            System.out.println("교수 입니다.");
        }
        else if(person instanceof Students) {
            System.out.println("학생 입니다.");
        }
        else if(person instanceof Researcher) {
            System.out.println("연구자 입니다.");
        }
        else {
            System.out.println("사람입니다.");
        }
    }


    public static void main(String[] args) {
        Students students = new Students("학생 정재현");
        Researcher researcher = new Researcher("연구자 정민희");
        Professor professor = new Professor("교수 정해영");
        printInfo(students);
        printInfo(researcher);
        printInfo(professor);

    }
}
