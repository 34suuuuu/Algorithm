import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] dp = new int[10001][4];
		dp[1][1] = dp[2][1] = dp[3][1] = 1;
		dp[2][2] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;

		int test_case = sc.nextInt();
		for (int t = 0; t < test_case; t++) {
			int n = sc.nextInt();

			for (int j = 4; j <= n; j++) {
				dp[j][1] = dp[j - 1][1];
				dp[j][2] = dp[j - 2][1] + dp[j - 2][2];
				dp[j][3] = dp[j - 3][1] + dp[j - 3][2] + dp[j - 3][3];
			}

			System.out.println(dp[n][1] + dp[n][2] + dp[n][3]);
		}
	}
}
