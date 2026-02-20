import java.util.*;

class Solution {
    public int solution(int[] order) {        
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        
        for(int i = 1; i <= order.length; i++){
            stack.push(i);
            
            while(!stack.isEmpty() && stack.peek() == order[cnt]){
                stack.pop();
                cnt++;
            }
        }
        return cnt;
    }
}