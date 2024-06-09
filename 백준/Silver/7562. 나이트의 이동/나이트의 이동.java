import java.io.*;
import java.util.*;

public class Main {
	static int start_x, start_y, end_x, end_y, l;
	static int[][] maps;
	static boolean[][] visited;
	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			l = Integer.parseInt(br.readLine());
			maps = new int[l][l];
			visited = new boolean[l][l];

			st = new StringTokenizer(br.readLine());
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			end_x = Integer.parseInt(st.nextToken());
			end_y = Integer.parseInt(st.nextToken());

			bfs();
			sb.append(maps[end_x][end_y] + "\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {start_x, start_y});
		visited[start_x][start_y] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();

			for (int i = 0; i < 8; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
				if (!visited[nx][ny]) {
					que.add(new int[] {nx, ny});
					maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
					visited[nx][ny] = true;
				}
			}
		}
	}
}
