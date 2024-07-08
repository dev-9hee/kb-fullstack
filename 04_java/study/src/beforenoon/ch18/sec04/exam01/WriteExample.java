package beforenoon.ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

// Writer 는 문자 출력 스트림의 최상위 클래스로, 추상 클래스
// 모든 문자 출력 스트림이 기본적으로 가져야 할 메소드가 정의됨
public class WriteExample {
    public static void main(String[] args) {
        // 문자 기반 출력 스트림 생성
        try(Writer writer = new FileWriter("C:/Temp/test.txt")) {

            // 1문자씩 출력
            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);

            // char 배열 출력
            char[] arr = { 'C', 'D', 'E' };
            writer.write(arr);

            // 문자열 출력
            writer.write("FGH");

            // 버퍼에 잔류하고 있는 문자들을 출력하고, 버퍼를 비움
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
