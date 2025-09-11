package blogquiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlogQuiz08 {
    public static void main(String[] args) {
        // 맵의 특성중에 하나는 Key가 중복이 될 수 없으므로 중복되는 키값을 입력하면 데이터를 그대로 덮을 수 있다.
        Map<String, Customer> stringCustomerMap = new HashMap<>();

        stringCustomerMap.put("정재현", new Customer("정재현", 100));
        stringCustomerMap.put("정다현", new Customer("정다현", 90));
        stringCustomerMap.put("정헤영", new Customer("정헤영", 80));
        stringCustomerMap.put("정민희", new Customer("정민희", 70));

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("이름과 포인트를 입력하세요.");
            String string = scanner.next();
            if(string.equals("그만")) break;
            int point = scanner.nextInt();
            Customer customer = stringCustomerMap.get(string);
            int addPoint = customer.getPoint() + point;
            stringCustomerMap.put(string, new Customer(string, addPoint));

            showAll(stringCustomerMap);
        }
    }

    private static void showAll(Map<String, Customer> stringCustomerMap) {
        for(Map.Entry<String, Customer> entry : stringCustomerMap.entrySet()){
            System.out.println(entry + " ");
        }
    }
}
