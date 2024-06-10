import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] tmp = new int[numbers.length * numbers.length];

		int idx = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				tmp[idx] = numbers[i] + numbers[j];
				idx++;
			}
		}
		int[] tmp2 = Arrays.copyOf(tmp, idx);
		Arrays.sort(tmp2);

		idx = 0;
		int[] tmp3 = new int[tmp2.length];
		for (int i = 0; i < tmp2.length; i++) {
			if (i == 0 || tmp2[i] != tmp2[i - 1]) {
				tmp3[idx] = tmp2[i];
				idx++;
			}
		}
		int[] answer = Arrays.copyOf(tmp3, idx);
        return answer;
    }
}