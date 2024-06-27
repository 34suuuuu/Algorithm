import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        List<int[]> list = new ArrayList<>();
		int start = 0;
		int end = 0;

		int total = sequence[0];
		while (start <= end && end < sequence.length) {
			if (total == k) {
				list.add(new int[] {start, end});
				total -= sequence[start];
				start++;
			} else if (total < k && end < sequence.length - 1) {
				end++;
				total += sequence[end];
			} else {
				total -= sequence[start];
				start++;
			}
		}
		Collections.sort(list, (o1, o2) -> {
			return (o1[1] - o1[0]) - (o2[1] - o2[0]);
		});
        
        answer = list.get(0);
        return answer;
    }
}