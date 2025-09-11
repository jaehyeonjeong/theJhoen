public class WrapperClassMain {
    public static void main(String[] args) {
        char ch01 = '4';
        char ch02 = 'F';

        System.out.println(Character.toLowerCase('A'));
        System.out.println(Character.toUpperCase('a'));

        System.out.println(Character.isDigit(ch01)); // true
        System.out.println(Character.isDigit(ch02)); // true

        System.out.println(Character.isAlphabetic(ch01));
        System.out.println(Character.isAlphabetic(ch02));

        // "10"
        String strAge = "10";

        int nAge = Integer.parseInt(strAge);

        Integer nValue = Integer.valueOf(1000);
        System.out.println(nValue.toString());

        double pi = Double.parseDouble("3.15");
        System.out.println(pi * 10);

        if(nAge >= 10) {
            System.out.println("10살 이상입니다.");
        }
        else {
            System.out.println("10살 미만입니다.");
        }


        // Boxing vs UnBoxing

        // Boxing
        Integer hundred = Integer.valueOf(100);
        int num = hundred.intValue();

        // UnBoxing
        Integer ten = 10;   //Integer.valueOf(10);
        int num02 = ten;    //ten.intValue();

        System.out.println(num + num02);
    }
}
