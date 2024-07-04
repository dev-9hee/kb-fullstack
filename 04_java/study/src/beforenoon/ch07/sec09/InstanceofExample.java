package beforenoon.ch07.sec09;

public class InstanceofExample {
    // main() 메소드에서 바로 호출하기 위해 정적 메소드 선언, 클래스의 인스턴스를 생성하지 않고도 호출 가능
    // 다형성, Person 타입의 객체를 매개변수로 받는 personInfo() 메소드는
    // Person 객체뿐만 아니라 Person 의 자식 클래스인 Student 객체도 처리할 수 있음
    public static void personInfo(Person person) {
        System.out.println("name: " + person.name);
        person.walk();

        // person 이 참조하는 객체가 Student 타입인지 확인
//    if (person instanceof Studnet) { // 1단계
//        // Student 객체일 경우 강제 타입 변환
//        Student student = (Student) person; // 2단계
//        // Student 객체만 가지고 있는 필드 및 메소드 사용
//        System.out.println("studentNo: " + student.studentNo);
//        student.study();
//    }

        // person 이 참조하는 객체가 Student 타입일 경우
        // student 변수에 대입(타입 변환 발생)
        // person instanceof Student 를 통해 person 객체가 Student 타입인지 확인
        // 만약 person 객체가 Student 타입이라면, student 변수에 person 객체를 자동으로 강제 타입 변환하여 대입
        if (person instanceof Student student) {
            System.out.println("studentNo: " + student.studentNo);
            student.study();
        }
    }

    public static void main(String[] args) {
        // Person 객체를 매개값으로 제공하고 personInfo() 메소드 호출
        Person p1 = new Person("정지희"); // Person 클래스의 인스턴스화, 이를 통해 p1이라는 Person 객체가 생성
        personInfo(p1); // personInfo 메소드를 호출

        System.out.println();

        // Student 객체를 매개값으로 제공하고 personInfo() 메소드 호출
        Person p2 = new Student("몰라", 10);
        personInfo(p2);
    }
}
