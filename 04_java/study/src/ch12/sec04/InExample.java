package ch12.sec04;

// 키보드 입력
public class InExample {
    public static void main(String[] args) throws Exception {
        int speed = 0;
        int keyCode = 0;

        while(true) {
            // Enter 키를 읽지 않았을 경우에만 발생
            if (keyCode != 13 && keyCode != 10) {
                if (keyCode == 49) { // 숫자 1 키를 읽었을 경우
                    speed++;
                } else if (keyCode == 50) { // 숫자 2 키를 읽었을 경우
                    speed--;
                } else if (keyCode == 51) { // 숫자 3 키를 읽었을 경우
                    break;
                }
                System.out.println("-----------------------------");
                System.out.println("1. 증속 | 2. 감속 | 3. 중지");
                System.out.println("-----------------------------");
                System.out.println("현재 속도= " + speed);
                System.out.print("선택: ");
            }
            // 키를 하나씩 읽음
            keyCode = System.in.read();
        } // end of while
        System.out.println("프로그램 종료");
    }
}
