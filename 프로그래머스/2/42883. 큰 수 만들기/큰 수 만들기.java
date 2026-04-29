import java.util.*;

class Solution {
    public String solution(String number, int k) {        
        Stack<Character> stack = new Stack<>();
        int remove = 0;
        
        for(char c : number.toCharArray()){
            while(!stack.isEmpty() && c > stack.peek() && remove < k){    
                stack.pop();
                remove++;
            }
            stack.push(c);
        }
        
        while(remove < k){
            stack.pop();
            remove++;
        }
        
        StringBuilder  sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }
        return sb.toString();
    }
}