package afternoon.nested.nested;

public class Outer {
    private static String outerStatic = "outerStatic";
    private String outerInstance = "outerInstance"; // 인스턴스화가 되어야만 접근 가능

    static class Nested { // 내부 중첩 클래스
        private static String nestedStatic = "nestedStatic";
        private String nestedInstance = "nestedInstance"; // 인스턴스화가 되어야만 접근 가능

        public void print() {
            // 클래스 내부의 static 값에 접근
            System.out.println("nestedStatic = " + nestedStatic);
            System.out.println("outerStatic = " + outerStatic);

            // 클래스 내부의 non-static 값에 접근
            System.out.println("nestedInstance = " + nestedInstance);
//            System.out.println("outerInstance = " + outerInstance); // 접근 불가

        }
    }
}
