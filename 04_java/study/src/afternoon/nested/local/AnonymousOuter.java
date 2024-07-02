package afternoon.nested.local;

public class AnonymousOuter {
    private String outerInstance = "outerInstance";

    public void outerMethod(String methodParameter) { // methodParameter : 지역 변수
        String methodString = "methodString"; // 지역 변수

        // 인터페이스를 인스턴스화하고 그 다음에 필요 코드를 바로 구현하여 전달
        Print print = new Print() {
            String localInstance = "localInstance";

            @Override
            public void printLocal() {
                System.out.println("outerInstance = " + outerInstance);
                System.out.println("methodString = " + methodString);
                System.out.println("methodParameter = " + methodParameter);
                System.out.println("localInstance = " + localInstance);
            }
        };

        // 이름 없는 클래스의 인스턴스가 print 변수에 저장 되었으므로 바로 사용!
        print.printLocal();
    }

    public static void main(String[] args) {
        AnonymousOuter anonymousOuter = new AnonymousOuter();
        anonymousOuter.outerMethod("methodParameter");
    }
}
