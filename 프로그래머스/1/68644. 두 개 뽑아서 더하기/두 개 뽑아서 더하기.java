import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> result = new ArrayList<>();
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				int sum = numbers[i] + numbers[j];
				if (!result.contains(sum)) {
					result.add(sum);
				}
			}
		}
		Collections.sort(result);
		int[] answer = new int[result.size()];
		int idx = 0;
		for (Integer i : result) {
			answer[idx] = i;
			idx++;
		}
        return answer;
    }
}