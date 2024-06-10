import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	static class Point{
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			char[][] maps = new char[h][w];
			Queue<Point> point = new LinkedList<>();
			Queue<Point> fire = new LinkedList<>();

			for (int i = 0; i < h; i++) {
				maps[i] = br.readLine().toCharArray();
				for (int j = 0; j < w; j++) {
					if (maps[i][j] == '@') {
						point.add(new Point(i, j));
						maps[i][j] = '.';
					} else if (maps[i][j] == '*') {
						fire.add(new Point(i, j));
					}
				}
			}

			int count = 0;
			boolean escape = false;
			boolean[][] visit = new boolean[h][w];
			visit[point.peek().x][point.peek().y] = true;

			loop:
			while (true) {

				int size = fire.size();
				while (size-- > 0) {
					Point f = fire.poll();
					
					for (int i = 0; i < 4; i++) {
						int nh = f.x + dx[i];
						int nw = f.y + dy[i];

						if (nh < 0 || nh >= h || nw < 0 || nw >= w) {
							continue;
						}
						if (maps[nh][nw] != '.') {
							continue;
						}
						maps[nh][nw] = '*';
						fire.add(new Point(nh, nw));
					}
				}
				count++;
				size = point.size();
				while (size-- > 0) {
					Point now = point.poll();

					for (int i = 0; i < 4; i++) {
						int nh = now.x + dx[i];
						int nw = now.y + dy[i];

						if (nh < 0 || nh >= h || nw < 0 || nw >= w) {
							escape = true;
							break loop;
						}
						if (visit[nh][nw]) {
							continue;
						}
						if (maps[nh][nw] == '.') {
							visit[nh][nw] = true;
							point.add(new Point(nh, nw));
						}
					}
				}

				if (point.isEmpty()) {
					break;
				}
			}

			if (escape) {
				sb.append(count).append("\n");
			}else{
				sb.append("IMPOSSIBLE\n");
			}
		}
		System.out.println(sb.toString().trim());
	}
}