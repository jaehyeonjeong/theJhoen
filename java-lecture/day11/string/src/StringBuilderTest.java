public class StringBuilderTest {
    public static void main(String[] args) {
        // 불변 객체 이므로 값을 바꾸지 못함
        // String이 자주 바뀌면 메모리 낭비가 심해진다.
        StringBuilder stringBuilder = new StringBuilder();
        String str00 = stringBuilder.
                append("A").
                append("N").
                toString();  // 자기 자신을 반환하고 메서드를 이어서 사용할 수 있다.

        System.out.println(stringBuilder);
        System.out.println(str00);
        System.out.println(str00.equals(stringBuilder));

        long total = 100000;
        long startTime = System.currentTimeMillis();
        String str = "";
        for(int i = 0; i < total; i++) {
            str += "a";
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        System.out.println("==============================================");

        // StringBuilder를 쓰면 속도면에서 훨씬 졸음
        long startTime02 = System.currentTimeMillis();
        StringBuilder stringBuilder1 = new StringBuilder();
        for(int i = 0; i < total; i++) {
            stringBuilder1.append("a").append("1");
        }
        long endTime02 = System.currentTimeMillis();
        System.out.println(endTime02-startTime02);


        System.out.println("==============================================");

        long startTime03 = System.currentTimeMillis();

        for(int i = 0; i < total; i++) {
            str.concat("test");
        }

        long endTime03 = System.currentTimeMillis();
        System.out.println(endTime03-startTime03);
    }
}
