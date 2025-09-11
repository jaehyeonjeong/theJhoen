package review;

public class DIsCountServiceMain {
    public static int discount(Grade grade, int price) {
        int discountPercent = 0;
        if(grade == Grade.BASIC) {
            discountPercent = 10;
        } else if (grade == Grade.GOLD) {
            discountPercent = 20;
        }
        else if (grade == Grade.DIAMOND) {
            discountPercent = 30;
        }

        return price * discountPercent / 100;
    }
    public static void main(String[] args) {
        int price = 10_000;
        // 일반 String은 오타의 위험성이 있기 때문에 다른 방법을 고려해야한다.
        // 오타 방지 / 타입 안정성
        // enum은 new 생성을 할 수 없고, 상수로만 사용이 가능하다.
        int nBasic = discount(Grade.BASIC, price);
        int nGold = discount(Grade.GOLD, price);
        int nDiamond = discount(Grade.DIAMOND, price);
//        int nVip = discount("vip", price);
        System.out.println("BASIC 할인 금액 : " + nBasic);
        System.out.println("GOLD 할인 금액 : " + nGold);
        System.out.println("DIAMOND 할인 금액 : " + nDiamond);

        Grade[] grades = Grade.values();
        for(Grade grade : grades) {
            System.out.println(grade.ordinal());
            System.out.println(grade.name());
        }
    }
}
