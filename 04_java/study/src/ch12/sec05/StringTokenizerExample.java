package ch12.sec05;

import java.util.StringTokenizer;

// StringTokenizer 클래스
// 문자열에 여러 종류가 아닌 한 종류의 구분자만 있다면 StringTokenizer 사용 가능
// 구분자를 생략하면 공백이 기본 구분자가 됨
public class StringTokenizerExample {
    public static void main(String[] args) {
        String data1 = "홍길동&이수홍,박연수";
        String[] arr = data1.split("&|,");

        for(String token : arr) {
            System.out.println(token);
        }
        System.out.println();

        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2, "/");
        while (st.hasMoreTokens()) { // hasMoreTokens() : 남아 있는 문자열이 있는지 여부
            String token = st.nextToken(); // nextToken() : 문자열을 하나씩 가져옴
            System.out.println(token);
        }
    }
}
