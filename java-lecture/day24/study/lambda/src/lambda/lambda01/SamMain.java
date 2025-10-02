package lambda.lambda01;

public class SamMain {
    public static void main(String[] args) {
        SamInterface samInterface = ()->{
            System.out.println("run run run");
        };
        samInterface.run();

//        NotSamInterface notSamInterface = ()->{
//            System.out.println("not sam");
//        };
//
//        notSamInterface.go();
//        notSamInterface.run();

    }
}
