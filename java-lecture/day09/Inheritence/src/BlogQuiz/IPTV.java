package BlogQuiz;

public class IPTV extends ColorTV{
    private String strIP;

    public IPTV(String strIP, int size, int color) {
        super(size, color);
        this.strIP = strIP;
    }

    @Override
    public void printProperty(){
        System.out.println("""
                나의 IPTV는 %s 주소의 %d인치 %d컬러"""
                .formatted(strIP, getSize(), getColor()));
    }
}
