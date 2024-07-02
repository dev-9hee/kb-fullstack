package afternoon.nested.nested.ex1;

// 생성시 msg 를 받아서 전송하는 클래스
// 단, 네트워크를 통해서만 메시지가 전달이 가능한 상황이라고 가정
public class NetworkMsg {
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
