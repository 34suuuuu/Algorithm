import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int[] nums;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];
		int[] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int maxValue = dp[0] = nums[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			maxValue = Math.max(maxValue, dp[i]);
		}
		System.out.println(maxValue);

	}
}
