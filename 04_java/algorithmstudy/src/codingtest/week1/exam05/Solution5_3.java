package codingtest.week1.exam05;

import java.util.Arrays;

// 문제5) Lv.2 - 해시 / 전화번호 목록
// 강사님 풀이, 심화 (substring 과 equals 메서드를 활용해서도 풀 수 있음)
public class Solution5_3 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++)
            if(phone_book[i].length() < phone_book[i+1].length() &&
                    phone_book[i].equals(phone_book[i+1].substring(0, phone_book[i].length())))
                //phone_book[i+1].startsWith(phone_book[i])
                return false;

        return true;
    }
}
