package afternoon.nested.inner;

public class Outer {
    private static String outerStatic = "outerStatic";
    private String outerInstance = "outerInstance"; // 인스턴스화가 되어야만 접근 가능

    class Inner { // 내부 클래스
        private static String innerStatic = "innerStatic";
        private String innerInstance = "innerInstance"; // 인스턴스화가 되어야만 접근 가능

        public void print() {
            // 클래스 내부의 static 값에 접근
            System.out.println("innerStatic = " + innerStatic);
            System.out.println("outerStatic = " + outerStatic);

            // 클래스 내부의 non-static 값에 접근
            System.out.println("innerInstance = " + innerInstance);
            System.out.println("outerInstance = " + outerInstance); // 접근 가능

        }
    }
}
