package string.enumeration;

public class EnumMain {
    public static void main(String[] args) {
        System.out.println(Grade.BASIC);
        System.out.println(Grade.GOLD);
        System.out.println(Grade.DIAMOND);

        System.out.println(Grade.BASIC.ordinal());
        System.out.println(Grade.GOLD.ordinal());
        System.out.println(Grade.DIAMOND.ordinal());


        System.out.println(Grade.BASIC.getPercent());
        System.out.println(Grade.GOLD.getPercent());
        System.out.println(Grade.DIAMOND.getPercent());


        System.out.println(Grade.BASIC.discount(1000));
        System.out.println(Grade.GOLD.discount(1000));
        System.out.println(Grade.DIAMOND.discount(1000));


        System.out.println(Grade.BASIC.getName());
        System.out.println(Grade.GOLD.getName());
        System.out.println(Grade.DIAMOND.getName());
    }
}
