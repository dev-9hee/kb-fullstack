package beforenoon.ch16.sec05.exam03;

// 생성자 참조 : 객체를 생성하는 것
// 람다식이 단순히 객체를 생성하고 리턴하도록 구성되면 람다식을 생성자 참조로 대치 가능 (a, b) -> { return new 클래스(a, b) }
// 클래스 :: new // 해당 생성자가 존재하지 않으면 컴파일 오류 발생
public class ConstructorReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();

        Member m1 = person.getMember1(Member :: new);
        System.out.println(m1);
        System.out.println();

        Member m2 = person.getMember2(Member::new);
        System.out.println(m2);
        System.out.println();
    }
}
