import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, K;
	static char[][] maps;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		maps = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			maps[i] = s.toCharArray();
		}

		dfs(R - 1, 0, 1);
		System.out.println(cnt);

	}

	public static void dfs(int x, int y, int length) {
		visited[x][y] = true;

		if(x == 0 && y == C - 1 && length == K) {
			cnt++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || maps[nx][ny] == 'T') {
				continue;
			}
			visited[nx][ny] = true;
			dfs(nx, ny, length + 1);
			visited[nx][ny] = false;

		}
	}
}
