package people;

public class PeopleMain {
    public static void main(String[] args) {
        Person person;
        Students students = new Students("정재현");
        person = students; // 업 캐스팅

        // down 캐스팅 : 부모의 범위가 더 크기 때문에 형을 지정해줘야 한다.
        Person person1 = new Students("정다현");
        Students students1 = (Students) person1;

//        System.out.println((Students)person1.name); // 컴파일 에러
        System.out.println(students1.name);


//        printInfo(Person person) {
//            instanceof
//        }
    }
}
