public class Main{
    public static void main(String[] args) {
        // 묵시적 형(type)변환(casting) 작은걸 큰거에 넣을 떄
        // 작은게 큰거로 들어가기 때문에 widening casting 이라고 함
        // 명시적 형변환 큰거를 작은거에 넣을 때

        //묵시적 widening casting
        int intVal = 100;
        long longVal = intVal;
        double doubleval = longVal;

        System.out.println("int : " + intVal);
        System.out.println("long : " + longVal);
        System.out.println("double : " + doubleval);


        // 명시적 narrow casting
        double double02 = 10.34;
        int intVal02 = (int)double02;
        System.out.println("into2 : " + intVal02);
        // 실수에서 정수로 변환 시 소수점 아래부분은 자른다.


        long longVal02 = 232323232324L;
        int intVal03 = (int)longVal02;
        System.out.println("int : " + intVal03);
        System.out.println((double)10 / 4);
        System.out.println(10.0 / 4);
    }
}