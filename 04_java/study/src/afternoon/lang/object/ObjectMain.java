package afternoon.lang.object;

public class ObjectMain {
    public static void main(String[] args) {
        Child child = new Child();// ctrl + alt + v

        // child 는 자신의 메서드와 부모의 메서드를 전부 사용 가능
        child.childMethod();
        child.parentMethod();

        System.out.println(child.toString()); // Object 안에 있는 메서드 사용 가능
        System.out.println(child); // toString() 을 찾아서 실행, 결과 같음, Child@404b9385(메모리 참조 주소)

        // hashCode()는 Java 에서 객체의 해시 코드를 반환하는 메서드
        String ref1 = Integer.toHexString(child.hashCode()); // 16진수로 변환
        String ref2 = Integer.toHexString(System.identityHashCode(child)); // child 객체의 실제 메모리 주소를 반환

        System.out.println("ref1 = " + ref1);
        System.out.println("ref2 = " + ref2);

        Parent[] objects = { new Parent(), new Child() };
        Object[] objects2 = { new Parent(), new Child(), new OtherClass() }; // Object 는 모든 클래스의 부모

        System.out.println(size(objects)); // 2
        System.out.println(size(objects2)); // 3

    }

    public static int size(Object[] obj) {
        return obj.length;
    }
}
