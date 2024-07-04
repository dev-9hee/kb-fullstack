package beforenoon.ch16.sec05.exam01;

// 메소드 참조 : 메소드를 참조해 매개변수의 정보 및 리턴 타입을 알아내 람다식에서 불필요한 매개변수를 제거, 단순화
public class MethodReferenceExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 정적 메소드일 경우 람다식
//        person.action((x, y) -> Computer.staticMethod(x, y));
        // 정적 메소드 참조 => 클래스 이름 :: 정적 메소드 이름
        person.action(Computer :: staticMethod);

        // 인스턴스 메소드일 경우
        Computer com = new Computer();
        // 람다식
//        person.action((x, y) -> com.instanceMethod(x, y));
        // 인스턴스 메소드 참조 => 참조 변수 이름(객체 생성) :: 인스턴스 메소드 이름
        person.action(com :: instanceMethod);
    }
}
