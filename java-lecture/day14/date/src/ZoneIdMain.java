import java.time.ZoneId;

public class ZoneIdMain {
    public static void main(String[] args) {
        for(String zoneID : ZoneId.getAvailableZoneIds()) {
            //System.out.println(zoneID);

        }
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("ZoneId.systemDefault() == " + zoneId);
        ZoneId arizona = ZoneId.of("US/Arizona");
        System.out.println("arizona === " + arizona);
    }
}
