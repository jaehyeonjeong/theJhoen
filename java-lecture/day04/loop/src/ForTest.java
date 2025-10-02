public class ForTest {
    public static void main(String[] args) {
        int i, nEnd = 10;
        int nSum = 0;
        int nEven = 0, nOdd = 1;
        for(i = 0; i <= nEnd; i++) {
            if(i % 2 == nEven){
                System.out.print(i);
                nSum += i;
                if(i == nEnd || i == nEnd - 1)
                    continue;
                System.out.print("+");
            }
         }
        System.out.println("=" + nSum); // println 함수는 맨 뒤에만 줄바꿈을 진행
    }
}
