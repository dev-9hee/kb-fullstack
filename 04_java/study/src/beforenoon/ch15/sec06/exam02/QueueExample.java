package beforenoon.ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

// Queue 인터페이스 : 선입선출(FIFO) 자료구조
// LinkedList : Queue 인터페이스를 구현한 대표적인 클래스
public class QueueExample {
    public static void main(String[] args) {
        // Queue 컬렉션 생성
        Queue<Message> messageQueue = new LinkedList<>();

        // 메세지 넣기, offer() : 주어진 객체에 큐를 넣는다.
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "김자바"));

        // 메세지를 하나씩 꺼내어 처리
        while(!messageQueue.isEmpty()) {
            Message message = messageQueue.poll(); // poll() : 큐에서 객체를 빼냄
            switch(message.command) {
                case "sendMail":
                    System.out.println(message.to + "님에게 메일을 보냅니다.");
                    break;
                case "sendSMS":
                    System.out.println(message.to + "님에게 SMS 를 보냅니다.");
                    break;
                case "sendKakaotalk":
                    System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
                    break;
            }
        }
    }
}
