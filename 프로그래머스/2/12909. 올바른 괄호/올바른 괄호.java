import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = false;
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.add(c);
			} else {
				if (stack.size() == 0) {
					answer = false;
					return answer;
				}
				if (stack.peek() == '(') {
					stack.pop();
				}
			}
		}
		if (stack.size() == 0) {
			answer = true;
		} else {
			answer = false;
		}
        return answer  ;  
    }
}