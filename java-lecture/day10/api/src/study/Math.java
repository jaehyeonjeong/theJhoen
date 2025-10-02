package study;

public class Math extends StudyMain {
  
    Math(String type){
        super(type);
    }
    
    public void exam(){
        System.out.println(this.getType() + "을 시험보겠습니다.");
    }

    public static void main(String[] args) {
        Math math = new Math("수학 가 유형");
        math.exam();
    }
}
