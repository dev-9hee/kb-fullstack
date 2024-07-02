package afternoon.lang.immutable;

public class ImmutableMain {
    public static void main(String[] args) {
        ImmutableUser user1 = new ImmutableUser("효석"); // 불변 객체를 사용해서 인스턴스화
        ImmutableUser user2 = user1; // 객체 참조 값 복사를 막는 것은 불가능

        System.out.println("user1 = " + user1);
        System.out.println("user2 = " + user2);

        // 불변 객체의 값을 변경하려고 시도 할 때, ERR 발생!!
//        user2.setName("지희");

        // 참조하려는 객체가 붋변 객체임을 깨닫고 새롭게 인스턴스 생성
//        user2 = new ImmutableUser("지희"); // 새로 참조
//        user2.setName("자희"); // 참조가 연결이 안 되어있는거는 가비지 컬렉터가 치움
        user2 = user2.setName("지희");
        System.out.println("user2 의 이름을 '지희'로 변경");
        System.out.println("user1 = " + user1);
        System.out.println("user2 = " + user2); // 지희
    }
}
