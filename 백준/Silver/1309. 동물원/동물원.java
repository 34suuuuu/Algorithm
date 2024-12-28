import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[][] dp = new long[n + 1][3];
		dp[1][0] = dp[1][1] = dp[1][2] = 1;
		final long MOD = 9901;

		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
		}
		System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % MOD);
	}
}
