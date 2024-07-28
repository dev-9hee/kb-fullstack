package codingtest.week1.전화번호목록;

import java.util.*;

// 문제5) Lv.2 - 해시 / 전화번호 목록
// 내 풀이 - 정렬 사용
public class Solution1 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book); // 배열 정렬

        for (int i = 0; i < phone_book.length - 1; i++) {
            // contains 함수는 문자열의 전체 영역에서 검색 => 접두사에 사용하기에는 안 맞았음
            // startsWith 함수는 문자열의 시작 부분 또는 지정된 인덱스에서 시작하는 부분만 검사
            boolean isContain = phone_book[i+1].startsWith(phone_book[i]);
            if (isContain) { // 접두사이면
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        boolean result = sol.solution(new String[] {"119", "97674223", "1195524421"});
        System.out.println(result);
    }
}

/* 문제 분석
phone_book[] : 전화번호부에 적힌 전화번호를 담은 배열

리턴 : boolean 형
=> 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false
=> 그렇지 않으면 true
*/
