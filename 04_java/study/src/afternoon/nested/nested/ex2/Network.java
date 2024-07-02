package afternoon.nested.nested.ex2;

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

    // 생성시 msg 를 받아서 전송하는 클래스
    // 단, 네트워크를 통해서만 메시지가 전달이 가능한 상황이라고 가정
    private static class NetworkMsg { // static 이 붙어야 중첨 클래스라고 부름
        private String msg;

        public NetworkMsg(String msg) {
            this.msg = msg;
        }

        public void send() {
            System.out.println("네트워크 메세지를 전송합니다.");
            System.out.println(this.msg);
            System.out.println("네트워크 메세지를 전송 종료.");
        }
    }
}
