package afternoon.nested.nested.ex1;

import java.util.Random;

// 네트워크 역할을 하는 클래스
public class Network {
    private boolean networkCondition; // 네트워크 상태 저장 변수

    // 네트워크 상태를 점검하고 점검 결과를 리턴
    public boolean checkNetwork() {
        System.out.println("네트워크 상태를 점검합니다.");
        Random rand = new Random();

        networkCondition = rand.nextBoolean();
        if (networkCondition) {
            System.out.println("네트워크 상태 정상");
            return true;
        } else {
            System.out.println("네트워크 상태 비정상");
            return false;
        }
    }

    public void sendMsg(String msg) {
        NetworkMsg networkMsg = new NetworkMsg(msg);
        networkMsg.send();
    }
}
