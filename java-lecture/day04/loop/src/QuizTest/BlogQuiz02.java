package QuizTest;

public class BlogQuiz02 {
    public static void main(String[] args) {
//        2. 다음 2차원 배열 n을 출력하는 프로그램을 작성하라
//
//        int n[][] = {{1}, {1,2,3}, {1}, {1,2,3,4}, {1,2}} ;
//
//        1
//        1 2 3
//        1
//        1 2 3 4
//        1 2
        int n[][] = {{1}, {1,2,3}, {1}, {1,2,3,4}, {1,2}} ;
        int nLength[] = {1, 3, 1, 4, 2};

//        System.out.println(n[1][1]);
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < nLength[i]; j++) {
                System.out.print(n[i][j]);
            }
            System.out.println();
        }
    }
}
