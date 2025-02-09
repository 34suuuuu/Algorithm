import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] maps;
	static boolean[][] visited;
	static int[] dx = {0, 1};
	static int[] dy = {1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		maps = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		System.out.println("Hing");
	}

	public static void dfs(int x, int y) {
		if (maps[x][y] == -1) {
			System.out.println("HaruHaru");
			System.exit(0);
		}

		for (int i = 0; i < 2; i++) {
			int nx = x + (maps[x][y] * dx[i]);
			int ny = y + (maps[x][y] * dy[i]);

			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny]) continue;
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}
