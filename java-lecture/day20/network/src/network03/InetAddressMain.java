package network03;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getByName("localhost");
        System.out.println(localhost);

        InetAddress google = InetAddress.getByName("google.com");
        System.out.println(google);

        // 규모가 넓을 수록 아이피 개수도 늘어난다.
        InetAddress naver = InetAddress.getByName("naver.com");
        System.out.println(naver);

        InetAddress daum = InetAddress.getByName("daum.net");
        System.out.println(daum);
    }
}
