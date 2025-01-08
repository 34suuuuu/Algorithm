import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] maps;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maps = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				maps[i][j] = str.charAt(j)- '0';
			}
		}
		bfs(0, 0);
		System.out.println(maps[n - 1][m - 1]);
	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		visited[x][y] = true;

		while(!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(visited[nx][ny] ) continue;
				if(maps[nx][ny] <= 0) continue;
				
				queue.add(new int[] {nx, ny});
				visited[nx][ny] = true;
				maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
			}
		}
	}
}
