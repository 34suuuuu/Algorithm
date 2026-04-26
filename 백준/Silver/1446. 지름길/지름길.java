import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Distance{
	int start, end, dist;

	Distance(int start, int end, int dist){
		this.start = start;
		this.end = end;
		this.dist = dist;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		Distance[] list = new Distance[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			list[i] = new Distance(start, end, dist);

		}

		int[] dp = new int[d + 1];

		for (int i = 1; i <= d; i++) {
			dp[i] = dp[i - 1] + 1;

			for (Distance distance : list) {
				if (distance.end == i) {
					dp[i] = Math.min(dp[i], dp[distance.start] + distance.dist);
				}
			}
		}
		System.out.println(dp[d]);
	}

}
