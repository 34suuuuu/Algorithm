import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] costs = new int[n][3];
		int[][] dp = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			costs[i][0] = Integer.parseInt(st.nextToken());	//r
			costs[i][1] = Integer.parseInt(st.nextToken());	//g
			costs[i][2] = Integer.parseInt(st.nextToken());	//b
		}

		dp[0][0] = costs[0][0];    // r
		dp[0][1] = costs[0][1];    // g
		dp[0][2] = costs[0][2];    // b

		for (int i = 1; i < n; i++) {
            // 이번에 r을 선택한다면 이전에는 g or b
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0]; 
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
		}
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
	}
}
