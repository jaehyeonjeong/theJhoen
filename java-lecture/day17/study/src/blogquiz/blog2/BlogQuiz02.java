package blogquiz.blog2;

public class BlogQuiz02 {
    public static void main(String[] args) {
        WeakPassword weakPassword = new WeakPassword("3425354");
        try {
            System.out.println(weakPassword.checkPassWord());
        } catch (WeakPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}
