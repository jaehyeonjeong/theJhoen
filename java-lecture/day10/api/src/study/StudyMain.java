package study;

// 추상클래스
public abstract class StudyMain {
    private String type;

    public StudyMain(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }

    // 추상 메소드
    public abstract void exam();
}

