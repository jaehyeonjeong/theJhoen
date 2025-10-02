package Quiz;

public enum AuthGrade {
    GUEST(1, "손님"),
    MANAGER(2, "매니저"),
    ADMIN(3, "최고 관리자");
    private final int level;
    private final String desc;

    AuthGrade(int level, String desc) {
        this.level = level;
        this.desc = desc;
    }

    public int getCode() {
        return level;
    }

    public String getName() {
        return desc;
    }
}
