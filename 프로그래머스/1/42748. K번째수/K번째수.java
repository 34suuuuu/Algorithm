import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
		int[] answer = new int[len];
		int[] tmp;

		for (int i = 0; i < len; i++) {
			int start = commands[i][0] - 1;
			int end = commands[i][1];
			tmp = new int[end-start];

			int idx = 0;
			for (int j = start; j < end; j++) {
				tmp[idx] = array[j];
				idx++;
				// System.out.println(Arrays.toString(tmp));
			}
			Arrays.sort(tmp);
			answer[i] = tmp[commands[i][2]-1];
		}
        return answer;
    }
}