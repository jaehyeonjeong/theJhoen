package collectionpkg;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int nLength = 20;
        Random random = new Random();

        while(list.size() < nLength) {
            int nRand = random.nextInt(1, 101);
            list.add(nRand);
        }

        Collections.sort(list);
        System.out.println(list);

        Set<Integer> integerSet = new HashSet<>();

        while(integerSet.size() < nLength) {
            int nRand = random.nextInt(1, 101);
            integerSet.add(nRand);
        }

        List<Integer> integerList = new ArrayList<>(integerSet);


        System.out.println("오름차순 정렬 이전: " + integerList);
        Collections.sort(integerList);
        System.out.println("오름차순 정렬 이후: " + integerList);

        System.out.println("========================================================");
        for(int i = 0; i < 3; i++)
        {
            System.out.println("이번주 로또 " + (i + 1) + "등 당첨 번호 : ");
            Set<Integer> lottoSet = new HashSet<>();

            int nTotallottoSize = 7;

            while (lottoSet.size() < nTotallottoSize) {  // 7자리 만큼 숫자를 집어넣음
                int nRandLottoNum = random.nextInt(1, 46);  // 1 부터 45까지의 수 출력
                lottoSet.add(nRandLottoNum);    // 랜덤 수 add
            }
            List<Integer> lottoList = new ArrayList<>(lottoSet);

            System.out.println("당첨 번호(정렬 전) : " + lottoList);
            Collections.sort(lottoList);    // 오름차순 정렬
            System.out.println("당첨 번호(정렬 후) : " + lottoList);


        }
    }
}
