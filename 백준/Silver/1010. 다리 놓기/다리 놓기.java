import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		dp = new int[30][30];
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			sb.append(combination(m, n)).append("\n");
		}
		System.out.println(sb);

	}

	static int combination(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r];
		}

		if(n == r || r == 0) {
			return dp[n][r] = 1;
		}

		return dp[n][r] = combination(n - 1, r) + combination(n - 1, r - 1);
	}
}
