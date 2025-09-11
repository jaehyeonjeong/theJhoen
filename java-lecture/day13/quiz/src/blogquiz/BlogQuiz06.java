package blogquiz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlogQuiz06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, City> stringCityMap = new HashMap<>();

        while(true) {
            String strInput = scanner.nextLine();
            if(strInput.equals("그만")) {
                System.out.println("입력을 종료 합니다.");
                break;
            }
            String[] strArray = strInput.split(",");
            String name = strArray[0].trim();
            int longitude = Integer.parseInt(strArray[1].trim());
            int latitude = Integer.parseInt(strArray[2].trim());
            City city = new City(name, longitude, latitude);
            stringCityMap.put(name, city);
        }

//        Iterator<Map.Entry<String, City>> entryIterator = stringCityMap.entrySet().iterator();
//        while(entryIterator.hasNext()) {
//            Map.Entry<String, City> entry = entryIterator.next();
//            System.out.println(entry);
//        }
        // while 대신 간단하게 for문으로 전체를 출력할 수 있다.
        for (Map.Entry<String, City> entry : stringCityMap.entrySet()) {
            System.out.println(entry);
        }

        while(true) {
            String str = scanner.nextLine();
            if(str.equals("그만")) break;
            System.out.println(stringCityMap.get(str)); // str은 키 이므로 해당 키에 대한 벨류 값을 출력한다.
        }
    }
}
