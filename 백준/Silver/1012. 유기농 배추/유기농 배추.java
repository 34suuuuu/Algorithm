import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int m, n;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[][] maps;
	static boolean[][] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int test_case = Integer.parseInt(st.nextToken());
		for (int t = 0; t < test_case; t++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			maps = new int[m][n];
			visited = new boolean[m][n];

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				maps[x][y] = 1;
			}

			cnt = 0;
			for (int p = 0; p < m; p++) {
				for (int q = 0; q < n; q++) {
					if (maps[p][q] == 1 && !visited[p][q]) {
						dfs(p, q);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < m && ny < n ) {
				if (!visited[nx][ny] && maps[nx][ny] == 1) {
					dfs(nx, ny);
				}
			}
		}
	}
}
