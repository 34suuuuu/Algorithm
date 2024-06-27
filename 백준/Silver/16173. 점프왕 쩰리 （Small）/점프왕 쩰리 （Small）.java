import java.io.*;
import java.util.*;

public class Main {
	static int[][] maps;
	static int n;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		maps = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(bfs(0, 0));
	}

	static String bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x, y});
		visited[x][y] = true;

		while(!que.isEmpty()) {
			int[] cur = que.poll();

			if (maps[cur[0]][cur[1]] == -1) {
				// 마지막 지점에 도달
				return "HaruHaru";
			}

			// 아래로 이동하는 경우
			if (cur[0] + maps[cur[0]][cur[1]] < n && !visited[cur[0] + maps[cur[0]][cur[1]]][cur[1]]) {
				int nx = cur[0] + maps[cur[0]][cur[1]];
				que.add(new int[] {nx, cur[1]});
				visited[nx][cur[1]] = true;
			}

			// 오른쪽으로 이동하는 경우
			if (cur[1] + maps[cur[0]][cur[1]] < n && !visited[cur[0]][cur[1] + maps[cur[0]][cur[1]]]) {
				int ny = cur[1] + maps[cur[0]][cur[1]];
				que.add(new int[] {cur[0], ny});
				visited[cur[0]][ny] = true;
			}
		}
		return "Hing";
	}
}
