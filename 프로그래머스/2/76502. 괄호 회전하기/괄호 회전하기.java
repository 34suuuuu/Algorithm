import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
    for(int i=0; i<s.length(); i++){
        answer += chkRotation(s) ? 1 : 0;
        s = s.substring(1, s.length()) + s.substring(0, 1);
    }
        return answer;
    }
    
    public boolean chkRotation(String str){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<str.length(); i++){
            char cur = str.charAt(i);
            if(cur == '(' || cur == '{' || cur == '['){
                stack.push(cur);
            }else{
                if(!stack.isEmpty()){
                    char top = stack.pop();
                    if(top == '(' && cur == ')') continue;
                    else if(top == '{' && cur == '}') continue;
                    else if(top == '[' && cur == ']') continue;
                    else return false;
                }else return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}