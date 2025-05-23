import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] dp;
	static final int MOD = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		dp = new int[k + 1][n + 1];
		Arrays.fill(dp[1], 1);
		for (int i = 1; i <= k; i++) {
			dp[i][0] = 1;
		}

		for (int i = 2; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] %= MOD;
			}
		}
		System.out.println(dp[k][n]);
	}

}