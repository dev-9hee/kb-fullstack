package beforenoon.ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) throws Exception {
        String originalFileName = "C:/Temp/test.jpg";
        String targetFileName = "C:/Temp/test2.jpg";

        try (
            InputStream is = new FileInputStream(originalFileName);
            OutputStream os = new FileOutputStream(targetFileName);
        ) {
            byte[] data = new byte[1024]; // 배열 버퍼 생성
            while (true) {
                // 바이트를 더 읽을 수 없다면 -1을 리턴
                int num = is.read(data); // 최대 1024 바이트 읽기, 바이트를 읽고 배열에 저장한 다음 읽은 바이트 수를 리턴
                if (num == -1) break; // 파일을 다 읽으면 while 문 종료
                os.write(data, 0, num); // 읽은 데이터 파일에 쓰기
            }
            os.flush(); // 내부 버퍼 잔류 바이트 출력하고 버퍼를 비움

            System.out.println("복사가 잘 되어습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
