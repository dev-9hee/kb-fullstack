package beforenoon.ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 10, 20, 20 이 저장된 바이트를 파일로 출력해서 저장
public class WriteExample2 {
    public static void main(String[] args) {
        try {
            // 데이터 도착지를 test1.db 파일로 하는 바이트 출력 스트림 생성
            OutputStream os = new FileOutputStream("C:/temp/test1.db");

            byte a = 10;
            byte b = 20;
            byte c = 30;

            // 1byte 씩 출력
            os.write(a);
            os.write(b);
            os.write(c);

            os.flush(); // 내부 버퍼에 잔류하는 바이트를 출력하는 버퍼를 비움
            os.close(); // 출력 스트림을 닫아 사용한 메모리를 해제
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
