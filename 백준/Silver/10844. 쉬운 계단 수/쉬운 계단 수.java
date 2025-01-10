import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n + 1][10];
		final long mod = 1000000000;


		// 한자리수의 경우는 모두 1
		for (int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}

		// 길이가 2이상인 경우
		for (int i = 2; i <= n; i++) {
			// 0부터 9까지 시작하는 경우 탐색
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][1] % mod;
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][8] % mod;
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
			}
		}
		System.out.println(Arrays.stream(dp[n]).sum() % mod);
	}
}
