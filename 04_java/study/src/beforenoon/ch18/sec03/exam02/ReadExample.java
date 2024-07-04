package beforenoon.ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 바이트 입력 스트림 - 바이트 배열로 읽기
// C:/Temp/test2.db 에 저장한 내용을 끝까지 읽고 출력
public class ReadExample {
    public static void main(String[] args) {
        // 데이터 출발지를 test2.db 로 하는 입력 스트림 생성
        try(InputStream is = new FileInputStream("C:/Temp/test2.db")) {

            byte[] data = new byte[100];

            while(true) {
                // 최대 100byte 를 읽고 읽은 바이트는 data 에 저장, 읽은 수는 리턴
                int num = is.read(data);
                if(num == -1) break; // 파일 끝에 도달했을 경우

                // 읽은 바이트를 출력
                for(int i=0; i<num; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
