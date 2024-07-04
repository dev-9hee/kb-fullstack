package beforenoon.ch08.sec07;

public interface Service {
    // 디폴트 메소드
    default void defaultMethod1() {
        System.out.println("defaultMethod1 종속 코드");
        defaultCommon();
    }

    default void defaultMethod2() {
        System.out.println("defaultMethod2 종속 코드");
        defaultCommon();
    }

    // private 메소드
    private void defaultCommon() {
        System.out.println("defaultMethod 중복 코드A");
        System.out.println("defaultMethod 중복 코드B");
    }

    // 정적 메소드
    static void staticMethod1() {
        System.out.println("staticMethod1 종속 코드");
    }

    // private 정적 메소드
    private static void staticCommon() {}
}
