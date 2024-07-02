package afternoon.lang.wrapper;

public class PerformanceMain {
    public static void main(String[] args) {
        int max = 1_000_000_000; // 10억 회
        long startTime, endTime;

        // 기본형 타입 사용
        long sum1 = 0;
        startTime = System.currentTimeMillis(); // 현재 시간은 ms로 계산, 시작 시간 기록
        for (int i=0; i<max; i++) {
            sum1 += i;
        }
        endTime = System.currentTimeMillis();
        long spentTime = endTime - startTime;
        System.out.println("기본 자료형 연산에 걸린 시간 : " + spentTime + " ms"); //

        // Wrapper 클래스 사용
        Long sum2 = 0L;
        startTime = System.currentTimeMillis(); // 현재 시간은 ms로 계산, 시작 시간 기록
        for (int i=0; i<max; i++) {
            sum2 += i;
        }
        endTime = System.currentTimeMillis();
        long spentTime2 = endTime - startTime;
        System.out.println("래퍼 클래스 연산에 걸린 시간 : " + spentTime2 + " ms");
    }
}
