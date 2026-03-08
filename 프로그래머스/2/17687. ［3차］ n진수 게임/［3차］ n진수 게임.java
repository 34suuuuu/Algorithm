import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int num = 0;
        int len = 0;
        
        while(answer.length() < t){
            String convertNum = Integer.toString(num++, n); // 10진수 -> n진수
            
            for(String s : convertNum.split("")){
                if (len++ % m == p - 1) {
                    answer += s.toUpperCase();
                }
                if(answer.length() == t) break;
            }
        }
       
        return answer;
    }
}