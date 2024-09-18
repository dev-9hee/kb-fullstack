package study.리스트자르기;

import java.util.ArrayList;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = null;
        ArrayList<Integer> num=new ArrayList<>();
        switch (n) {
            case 1: {
                for (int i = 0; i <=slicer[1]; i++) {
                    num.add(num_list[i]);
                }
                break;
            }
            case 2: {

                for (int i = slicer[0]; i < num_list.length; i++) {
                    num.add(num_list[i]);
                }
                break;
            }
            case 3: {

                for (int i = slicer[0]; i <= slicer[1]; i++) {
                    num.add(num_list[i]);
                }
                break;
            }
            case 4: {
                for (int i = slicer[0]; i <= slicer[1]; i = i+slicer[2]) {
                    num.add(num_list[i]);
                }
                break;
            }
        }
        int a=num.size();
        answer=new int[a];
        for(int i=0; i<num.size();i++) {
            answer[i]=num.get(i);
        }


        return answer;
    }
}