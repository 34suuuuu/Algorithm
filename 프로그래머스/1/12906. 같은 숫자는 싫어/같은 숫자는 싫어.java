import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		Stack<Integer> stack = new Stack<>();

		stack.add(arr[0]);
		for (int i : arr) {
			if (i != stack.peek()) {
				stack.add(i);
			}
		}
        int idx = stack.size() - 1;
		answer = new int[stack.size()];
		while (!stack.isEmpty()) {
			answer[idx] = stack.pop();
			idx--;
		}
        return answer;
    }
}