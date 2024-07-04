package beforenoon.ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 바이트 출력
// 이 방법 권장!!!!!, 오전 강사님 추천 방법
// 10, 20, 20 이 저장된 바이트를 파일로 출력해서 저장
public class WriteExample {
    public static void main(String[] args) {
        // 데이터 도착지를 test1.db 파일로 하는 바이트 출력 스트림 생성
        // 출력일때는 해당 파일이 없으면 새로 생성됨, 존재할 경우 기존 데이터는 다 버리고 처음부터 새로 작성!!
        try (OutputStream os = new FileOutputStream("C:/temp/test1.db")) {
            byte a = 10;
            byte b = 20;
            byte c = 30;

            // 1byte 씩 출력
            os.write(a);
            os.write(b);
            os.write(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
