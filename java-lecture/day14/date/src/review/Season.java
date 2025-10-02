package review;

public enum Season {
    SPRING(1,"봄"),
    SUMMER(2,"여름"),
    FALL(3,"가을"),
    WINTER(4,"겨울"),
   ;


    private final String displayName;
    private final int code;

    Season(int code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getCode() {
        return code;
    }
}

