import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());

		for (int t = 0; t < test_case; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] stickers = new int[2][n];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] dp = new int[2][n];
			dp[0][0] = stickers[0][0];
			dp[1][0] = stickers[1][0];

			for (int i = 1; i < n; i++) {
				if (i == 1) {
					dp[0][i] = dp[1][0] + stickers[0][1];
					dp[1][i] = dp[0][0] + stickers[1][1];
					continue;
				}
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + stickers[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + stickers[1][i];
			}

			sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
		}
		System.out.println(sb);
	}
}
