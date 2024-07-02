package afternoon.lang.wrapper;

// 래퍼 오토 박싱
public class AutoBoxingMain {
    public static void main(String[] args) {
        // 박싱
        Integer integer1 = 10;
        Long long1 = 100L;
        Double double1 = 11.18;

        // 언박싱
        System.out.println("integer1 = " + integer1);
        System.out.println("long1 = " + long1);
        System.out.println("double1 = " + double1);
    }
}
