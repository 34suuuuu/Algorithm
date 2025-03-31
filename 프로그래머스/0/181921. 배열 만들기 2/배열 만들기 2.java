import java.util.*;
class Solution {
    public List<Integer> solution(int l, int r) {
        List<Integer> answer = new ArrayList<>();
        
        for(int i=l; i<= r; i++){
            boolean flag = true;
            String s = Integer.toString(i);
            for(char c : s.toCharArray()){
                if(c != '0' && c != '5') flag = false;
            }
            if(flag){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){
            answer.add(-1);
        }
        return answer;
    }
}