package quiz;

import java.awt.*;

public class IPTV extends ColorTV {

    private String strIP = "127.0.0.1";

    public IPTV(String strIP)
    {
        super(70, 1920 * 1024);
        this.strIP = strIP;
    }

    public IPTV(String strIP, int size, int color) {
        super(size, color);
        this.strIP = strIP;
    }

    @Override
    public void printProperty() {
        System.out.println("나의 IPTV 는 " + strIP + "라는 IP주소의 ");
        super.printProperty();
    }
}
