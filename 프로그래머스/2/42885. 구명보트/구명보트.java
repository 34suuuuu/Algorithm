import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
		Arrays.sort(people);

		for (int i : people) {
			deque.add(i);
		}

		while(!deque.isEmpty()) {
			int last = deque.pollLast();
			answer++;

			if (deque.size() >= 1 && last + deque.peekFirst() <= limit) {
				deque.pollFirst();
			}

		}
        return answer;
    }
}