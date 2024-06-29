package afternoon.memory;

public class Counter {
    public static int counter = 0; // 클래스에 고정된 유일한 친구

    public Counter() { // 이 클래스가 인스턴스화되면 그 횟수를 증가
        counter++; // this 라는 지칭어 필요 없음
    }
}
