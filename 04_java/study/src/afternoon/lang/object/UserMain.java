package afternoon.lang.object;

public class UserMain {
    public static void main(String[] args) {
        User user1 = new User("정지희", "wjdwlmgl");
        User user2 = new User("정지희", "wjdwlmgl");

        System.out.println(user1 == user2); // false, 참조 주소 값이 다름
        System.out.println(user1.equals(user2)); // 기본 구현은 객체의 주소 값을 비교, 깊은 비교는 따로 오버라이딩을 해서 사용
        // 오버라이딩 후 false => true

    }
}
