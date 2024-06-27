class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

		long left = 0;
		long right = times[times.length - 1] * (long)n;
		long mid = 0;

		long complete = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			complete = 0;

			for (int i : times) {
				complete += (mid / i);
			}
			if (complete < n) {
				left = mid + 1;
			} else {
				right = mid - 1;
				answer = mid;
			}
		}
		return answer;
    }
}