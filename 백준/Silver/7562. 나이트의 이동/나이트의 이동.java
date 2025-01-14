import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int size;
	static int x1, y1, x2, y2;
	static int[][] maps;
	static boolean[][] visited;
	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());

		for (int t = 0; t < test_case; t++) {
			size = Integer.parseInt(br.readLine());

			maps = new int[size][size];
			visited = new boolean[size][size];

			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			bfs();

			sb.append(maps[x2][y2]).append("\n");
		}
		System.out.println(sb);
	}

	public static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[]{x1, y1});
		visited[x1][y1] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int curX = cur[0];
			int curY = cur[1];

			for (int i = 0; i < 8; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if(nx<0 || nx>=size || ny<0 || ny>=size || visited[nx][ny]) continue;
				
				que.add(new int[]{nx, ny});
				maps[nx][ny] = maps[curX][curY] + 1;
				visited[nx][ny] = true;
			}
		}
	}
}
