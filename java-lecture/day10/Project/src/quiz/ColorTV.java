package quiz;

public class ColorTV extends TV{
    private int color;
    public ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }

    public void printProperty() {
        System.out.println("""
                %d인치 %d컬러 텔레비젼"""
                .formatted(getSize(), color));
    }
}
