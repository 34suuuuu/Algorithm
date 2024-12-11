import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][] maps;
	static final int INF = 10000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		maps = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(maps[i], INF);
			maps[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			maps[start - 1][end - 1] = Math.min(maps[start - 1][end - 1], cost);
		}

		floyd();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sb.append(maps[i][j] == INF ? 0 : maps[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static void floyd() {
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					maps[i][j] = Math.min(maps[i][k] + maps[k][j], maps[i][j]);
				}
			}
		}
	}
}
