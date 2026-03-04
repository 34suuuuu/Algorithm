import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int cnt = picks[0] + picks[1] + picks[2]; //총 곡괭이 수
        int N = Math.min(cnt, minerals.length/5 + 1);
        
        int dp = 0, ip = 0, sp = 0;
        int[][] tiredness = new int[N][3];
        for(int i = 0; i < minerals.length; i += 5){
            if(i/5 == N) break;
            
            for(int j = i; j < i+5; j++){                
                if(minerals[j].equals("diamond")){
                    dp += 1;
                    ip += 5;
                    sp += 25;
                }else if(minerals[j].equals("iron")){
                    dp += 1;
                    ip += 1;
                    sp += 5;
                }else if(minerals[j].equals("stone")){
                    dp += 1;
                    ip += 1;
                    sp += 1;
                }
                if(j==minerals.length-1){
                    break;
                }
            }
            tiredness[i/5][0] = dp;
            tiredness[i/5][1] = ip;
            tiredness[i/5][2] = sp;
                
            dp = ip = sp = 0;
        }
        
        Arrays.sort(tiredness, (o1, o2) -> (o2[2] - o1[2]));
        
        for(int i = 0; i < N; i++){
            if(picks[0]!=0){
                answer += tiredness[i][0];
                picks[0]--;
            }
            else if(picks[1]!=0){
                answer += tiredness[i][1];
                picks[1]--;
            }
            else if(picks[2]!=0) {
                answer += tiredness[i][2];
                picks[2]--;
            }                
        }
        
        
        
        return answer;
    }
}