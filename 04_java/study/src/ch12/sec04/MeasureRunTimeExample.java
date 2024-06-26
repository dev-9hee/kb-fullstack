package ch12.sec04;

// 진행 시간 읽기
// long nanoTime() : 1/10^9 초 단위로 진행된 시간을 리턴
public class MeasureRunTimeExample {
    public static void main(String[] args) {
        long time1 = System.nanoTime();
        int sum = 0;
        for(int i=1; i<=1000000; i++) {
            sum += i;
        }
        long time2 = System.nanoTime();

        System.out.println("1~1000000까지의 합: " + sum);
        System.out.println("계산에 " + (time2 - time1) + " 나노초가 소요되었습니다.");
    }
}
