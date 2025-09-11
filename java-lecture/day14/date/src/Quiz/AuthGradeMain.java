package Quiz;

public class AuthGradeMain {
    public static void main(String[] args) {
        AuthGrade[] authGrades = AuthGrade.values();

        for (AuthGrade authGrade : authGrades) {
            System.out.println("AuthGrade name : " + authGrade.name()
                    + ", 레벨 : " + authGrade.getCode()
                    + ", 명칭 : " + authGrade.getName());
        }
    }
}
