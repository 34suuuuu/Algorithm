import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static int[] operator = new int[4];
	static int n;
	static int maxVal = Integer.MIN_VALUE;
	static int minVal = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());

		nums = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		st= new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		backtracking(1, nums[0]);
		System.out.println(maxVal);
		System.out.println(minVal);
	}

	private static void backtracking(int idx, int sum) {
		if (idx == n) {
			maxVal = Math.max(maxVal, sum);
			minVal = Math.min(minVal, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;

				if (i == 0) {
					backtracking(idx + 1, sum + nums[idx]);
				} else if (i == 1) {
					backtracking(idx + 1, sum - nums[idx]);
				} else if (i == 2) {
					backtracking(idx + 1, sum * nums[idx]);
				} else {
					backtracking(idx + 1, (int)(sum / nums[idx]));
				}
				operator[i]++;
			}
		}
	}
}
