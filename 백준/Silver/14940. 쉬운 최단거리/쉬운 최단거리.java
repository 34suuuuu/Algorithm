import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] maps, dist;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maps = new int[n][m];
		dist = new int[n][m];
		visited = new boolean[n][m];

		int start_x = -1, start_y = -1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				if (maps[i][j] == 2) {
					start_x = i;
					start_y = j;
				}
			}
		}

		bfs(start_x, start_y);

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if (!visited[i][j] && maps[i][j] == 1) {
					sb.append(-1 + " ");
				} else {
					sb.append(dist[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x, y});
		visited[x][y] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(visited[nx][ny] || maps[nx][ny] == 0) continue;

				visited[nx][ny] = true;
				dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
				que.add(new int[] {nx, ny});

			}
		}

	}
}
