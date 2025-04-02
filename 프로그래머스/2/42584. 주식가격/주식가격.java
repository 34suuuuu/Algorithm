import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length-1; i++){
            int cur = prices[i];
            int sec = 0;
            
            for(int j= i+1; j<prices.length; j++){
                int next = prices[j];
                sec++;
                
                if(cur > next){
                    break;
                }
            }
            answer[i] = sec;
        }
        
        return answer;
    }
}