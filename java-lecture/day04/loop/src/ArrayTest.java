public class ArrayTest {
    public static void main(String[] args) {
        // Array
        // 순서없는 것들에 순서를 매기는 것을 말함.
        // 이름1, 이름2, 이름3,
        String [][] strArray = new String[4][2]; // String배열로 참조 -> 배열을 표시할 떄에는 변수 옆에 []를 붙여준다.
        // Array는 index 시작이 반드시 0부터 시작한다.
        strArray[0][0] = "정재현";
        strArray[0][1] = "정다현";
        strArray[1][0] = "정해영";
        strArray[1][1] = "정민희";

        // 베열은 기본타입이 아닌 참조타입이다.
//        for(int i = 0; i < 4; i++) {
//            System.out.println(strArray[i] + ", ");
//        }

        int num = 10;
        String strArray02[] = {"정해영", "정민희", "정재현", "정다현"};
        int nIndex = 0;
        while(nIndex < 4){
            System.out.println(strArray02[nIndex]);
            nIndex++;
        }

        int nIntArray[] = new int[5];
        for(int i = 0; i < 5; i++){
            nIntArray[i] = i;
        }
        int myArray[] = nIntArray; // 얕은 복사 : 같은 메모리 주소를 가짐
        // 배열은 참조이기 때문에 얕은복사가 이루어짐
        for(int i = 0; i < 5; i++) {
            System.out.print(myArray[i]+ ", ");
        }

        // primitive는 데이터의 값자체을 가져오기 떄문에 깊은복사가 이루어짐


        // Arrays를 훨씬 더 많이 쓰인다.
    }
}
