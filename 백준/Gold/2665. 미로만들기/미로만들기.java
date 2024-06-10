import java.io.*;
import java.util.*;

public class Main {
	static class Point{
		int x,y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n;
	static char[][] maps; // 1 : 흰색, 0: 검은색
	static int[][] dist;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		maps = new char[n][n];
		dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < n; j++) {
				maps[i][j] = str.charAt(j);
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs();
		System.out.println(dist[n - 1][n - 1]);
	}

	public static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		dist[0][0] = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
				if (dist[nx][ny] > dist[cur.x][cur.y]) {
					if (maps[nx][ny] == '1') {
						dist[nx][ny] = dist[cur.x][cur.y];
					} else {
						dist[nx][ny] = dist[cur.x][cur.y] + 1;
					}
					queue.add(new Point(nx, ny));
				}
			}
		}
	}
}
