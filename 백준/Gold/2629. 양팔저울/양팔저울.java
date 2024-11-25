import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,m ;
	static int[] weights;
	static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		weights = new int[n];
		dp = new boolean[n+1][15001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}

		getWeights(0, 0);
		StringBuilder sb = new StringBuilder();
		m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());

			if(num > 15000) sb.append("N ");
			else sb.append(dp[n][num] ? "Y " : "N ");
		}
		System.out.println(sb);
	}

	static void getWeights(int num, int weight) {
		if(dp[num][weight]) return;

		dp[num][weight] = true;
		if(num == n) return;

		getWeights(num + 1, weight + weights[num]);
		getWeights(num + 1, weight);
		getWeights(num + 1, Math.abs(weight - weights[num]));
	}
}
