package beforenoon.ch15.sec02.exam01;

import java.util.ArrayList;
import java.util.List;

// ArrayList : 객체를 추가하면 내부 배열에 객체가 저장되고 제한 없이 객체 추가 가능
// 객체의 번지를 저장, 동일한 객체를 중복 저장 시 동일한 번지가 저장, null 저장 가능
// 빈번한 객체 삭제와 삽입이 일어나는 곳에선 바람직하지 않음
public class ArrayListExample {
    public static void main(String[] args) {
        // ArrayList 컬렉션 생성
        List<Board> list = new ArrayList<>(); // Board 타입의 객체만 저장

        // 객체 주가
        list.add(new Board("제목1", "내용1", "글쓴이1"));
        list.add(new Board("제목2", "내용2", "글쓴이2"));
        list.add(new Board("제목3", "내용3", "글쓴이3"));
        list.add(new Board("제목4", "내용4", "글쓴이4"));
        list.add(new Board("제목5", "내용5", "글쓴이5"));

        // 저장된 총 객체 수 얻기
        int size = list.size();
        System.out.println("총 객체 수(size) : " + size); // 5
        System.out.println();

        // 특정 인덱스의 객체 가져오기
        Board board = list.get(2); // 주어진 인덱스에 저장된 객체를 리턴
        System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWriter()); // 제목3
        System.out.println();

        // 모든 객체를 하나씩 가져오기, 중요
        for(int i=0; i<list.size(); i++) {
            Board b = list.get(i);
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }
        System.out.println();

        // 객체 삭제
        list.remove(2); // 제목3 삭제, 당김 발생
        list.remove(2); // 제목4 삭제

        // 향상된 for 문으로 모든 객체를 하나씩 가져오기, 중요
        for(Board b : list) {
            System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
        }
    }
}
