package beforenoon.ch18.sec04.exam02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// Reader : 문자 입력 스트림의 최상위 클래스, 추상 클래스
// 문자 입력 스트림이 기본적으로 가져야 할 메소드가 정의됨
public class ReadExample {
    public static void main(String[] args) {
        try {
            Reader reader = null;

            // 1문자씩 읽기
            reader = new FileReader("C:/Temp/test.txt");
            while (true) {
                int data = reader.read(); // 1개 문자를 읽고 리턴
                if (data == -1) break;
                System.out.print((char) data);
            }
            reader.close(); // 입력 스트림을 닫고, 사용 메모리 해제
            System.out.println();

            // 문자 배열로 읽기
            reader = new FileReader("C:/Temp/test.txt");
            char[] data = new char[100];
            while(true) {
                int num = reader.read(data); // 읽은 문자들을 매개값으로 주어진 문자 배열에 저장하고 읽은 문자 수를 리턴
                if (num == -1) break;
                for (int i = 0; i < num; i++) {
                    System.out.print(data[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
