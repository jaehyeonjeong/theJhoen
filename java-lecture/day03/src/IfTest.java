public class IfTest {
    public static void main(String[] args) {
        boolean condition = true;
        int myAge = 20;

        // 비교 연산자 결과 boolean
//        if(myAge > 20){
        if(condition) {
            // if 조건이 참인 경우 {} 중괄호 안에 있는 문장을 실행
            System.out.println("성인입니다.");
        }
        else { // 특정 조건을 배제한 나머지 조건
            System.out.println("성인이 아닙니다. 미성년자");
        }
        System.out.println("여기는 조건문 실행 후 출력하는 부분입니다.");

        System.out.println("====================================");

        int nScore = 85;
        if(nScore > 80) {
            System.out.println("합격");
        }else{
            System.out.println("불합격");
        }

        System.out.println("====================================");
        if(nScore > 90) {
            System.out.println('A');
        }
        else if(nScore > 80) {
            System.out.println('B');
        }
        else{
            System.out.println('C');
        }
    }
}

