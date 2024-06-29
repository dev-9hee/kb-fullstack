package loop;

public class DoWhile2 {

    public static void main(String[] args) {
        int i = 10;

        // do-while 문은 최초 한번은 항상 실행
        do { // 일단 실행
            System.out.println("현재 숫자는: " + i);
            i++;
        } while (i < 3); // 참이면 다시 실행, 거짓이면 빠져나옴
    }
}
