import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();

		int l1 = a.length();
		int l2 = b.length();
		int[][] dp = new int[l2 + 1][l1 + 1];
		Arrays.fill(dp[0], 0);

		for (int i = 1; i <= l2; i++) {
			for (int j = 1; j <= l1; j++) {
				if (b.charAt(i - 1) == a.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[l2][l1]);

	}
}
