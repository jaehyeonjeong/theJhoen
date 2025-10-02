package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        int dataTotal = 100000;
        int insertTotal = 10000;

        List<Integer> arrayList = new ArrayList<>();
        for(int i =0; i < dataTotal; i++) {
            arrayList.add(i);
        }


        List<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < dataTotal; i++) {
            linkedList.add(i);
        }

        long starTime = System.currentTimeMillis();
        for(int i = 0; i < insertTotal; i++) {
            arrayList.add((int)(Math.random()*dataTotal), i);
        }

        long endTime = System.currentTimeMillis();
        System.out.println(endTime-starTime + "ms");

        long startTime1 = System.currentTimeMillis();
        for(int i = 0; i < insertTotal; i++) {
            linkedList.add((int)(Math.random()*dataTotal), i);
        }

        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1-startTime1 + "ms");
    }
}
