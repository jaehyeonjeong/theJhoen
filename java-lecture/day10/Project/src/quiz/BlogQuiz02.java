package quiz;

public class BlogQuiz02 {
    public static void main(String[] args) {
        IPTV iptv = new IPTV("192.168.1.200");
        iptv.printProperty();

        IPTV iptv1 = new IPTV("125.0.0.1", 40, 1560);
        iptv1.printProperty();
    }
}
