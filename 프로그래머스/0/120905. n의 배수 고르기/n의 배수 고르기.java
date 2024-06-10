import java.util.*;

class Solution {
    public List<Integer> solution(int n, int[] numlist) {
		List<Integer> answer = new ArrayList<>();
		int idx = 0;
		for (int i : numlist) {
			if (i % n == 0) {
				answer.add(i);
				idx++;
			}
		}
        return answer;
    }
}