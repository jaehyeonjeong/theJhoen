package QuizTest;

public class BlogQuiz01 {
    public static void main(String[] args) {
//
//        1. 100보다 작은 짝수의 합을 구하는 코드를 작성하시오.
//                for문과 while문으로 각각 작성하시오.
        int nSum = 0;
        for(int i = 0; i < 100; i+=2){  // 고친점 : <= -> < 이유는 100보다 작은 수를 나열해야하기 때문
            nSum += i;
        }

        System.out.println("for 문으로 구한 짝수의 합 : " + nSum);

        nSum = 0;

        int i = 0;
        // 자바는  스코프 안에 있는 변수에서는 바깥에 있는 요소를 부를 수 있고, 반대로 바깥쪽에서는 스코프 내부의 변수를 부를 수 없다.
        while(true){
            if(i >= 100) break; // 고친 점 : > -> >= 로 변경, 플로우 순서또한 변경
            nSum += i;
            i += 2;
        }

        System.out.println("while 문으로 구한 짝수의 합 : " + nSum);

    }
}
