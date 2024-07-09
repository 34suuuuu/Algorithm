import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n + 1][10];
		Arrays.fill(dp[1], 1);

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
				}
			}
		}
		System.out.println(Arrays.stream(dp[n]).reduce(0, (a, b) -> (a + b) % 10007));;
	}
}
