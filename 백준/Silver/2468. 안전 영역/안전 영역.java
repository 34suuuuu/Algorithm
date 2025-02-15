import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] maps;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maps = new int[n][n];

		int maxHeight = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(maxHeight, maps[i][j]);
			}
		}

		int result = 1;
		for (int h = 1; h <= maxHeight; h++) {
			visited = new boolean[n][n];
			int cnt = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (maps[i][j] > h && !visited[i][j]) {
						cnt++;
						dfs(i, j, h);
					}
				}
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}

	public static void dfs(int x,int y, int height) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
			if (maps[nx][ny] > height) {
				dfs(nx, ny, height);
			}
		}
	}
}
