package beforenoon.ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 바이트 입력 스트림 - 바이트 읽기
// C:/Temp/test1.db 에 저장한 내용을 1byte 씩 끝까지 읽음
public class ReadExample {
    public static void main(String[] args) {
        // 데이터 출발지를 test1.db 로 하는 입력 스트림 생성
        try (InputStream is = new FileInputStream("C:/Temp/test1.db")) {
            while(true) {
                int data = is.read(); // 1byte 씩 읽기
                if(data == -1) break; // 파일 끝에 도달했을 경우 while 문 빠져나옴
                System.out.println(data);
            }
        } catch (FileNotFoundException e) { // 주어진 파일이 존재하지 않을 경우
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
