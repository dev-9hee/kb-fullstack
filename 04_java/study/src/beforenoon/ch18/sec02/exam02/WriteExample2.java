package beforenoon.ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 바이트 배열 출력
// 10, 20, 30 이 저장된 바이트 배열을 C:/Temp/test2.db 파일로 출력해서 저장
public class WriteExample2 {
    public static void main(String[] args) {
        // 데이터 도착지를 test2.db 파일로 하는 바이트 출력 스트림 생성
        try(OutputStream os = new FileOutputStream("C:/Temp/test2.db")) {
            byte[] array = {10, 20, 30};

            os.write(array); // 배열의 모든 바이트를 출력

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
