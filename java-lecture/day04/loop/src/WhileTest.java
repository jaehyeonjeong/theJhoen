public class WhileTest {
    public static void main(String[] args) {
        int i = 0;
        while(true) { // while 안에는 조건식만 작성할 수 밖에 없다.
            System.out.print(i);
            if(i < 10) {
                System.out.print(", ");
            }
            i++;
            if(i > 10){
                break; // while문을 아예 빠져나감
                //continue; // 해당 조건문에서 연산을 진행하고 while문을 계속 진행
            }
        }
        System.out.println();
        int j = 0;
        for(;;){
            System.out.print(j);
            j++;
            if(j > 10) break;
        }
    }
}
