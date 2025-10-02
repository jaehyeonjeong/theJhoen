import java.util.Arrays;

public class Lotto02 {
    public static void main(String[] args) {
        // 1~45
        int nArrays[] = new int[45];
        Arrays.setAll(nArrays, i->i+1);

        System.out.println(Arrays.toString(nArrays));


        for(int i = 0; i < 45; i++){
            int nTemp;
            // 두개를 랜덤 변수로 만들어서 바꿔치기 진행
            int nSelect01 = (int)(Math.random() * 45);      // 0 ~ 44
            int nSelect02 = (int)(Math.random() * 45);      // 0 ~ 44

            if(nSelect02 == nSelect01) {
                i--;
            }
            nTemp = nArrays[nSelect01];
            nArrays[nSelect01] = nArrays[nSelect02];
            nArrays[nSelect02] = nTemp;
        }
        System.out.println();

        int[] lotto = Arrays.copyOf(nArrays, 6);
        System.out.println(Arrays.toString(nArrays));
        Arrays.sort(lotto);
        System.out.println(Arrays.toString(lotto));
    }
}
