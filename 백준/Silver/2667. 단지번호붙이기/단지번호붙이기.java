import java.io.*;
import java.util.*;

public class Main {
	static char[][] maps;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int n, result, cnt = 0;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());

		maps = new char[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			maps[i] = str.toCharArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (maps[i][j] == '1' && !visited[i][j]) {
					cnt = 1;
					bfs(i, j);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for (int i : list) {
			System.out.println(i);
		}
	}

	static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x, y, 1});
		visited[x][y] = true;

		while (!que.isEmpty()) {
			int[] cur = que.poll();
			result = cur[2];
			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if(nx<0 || ny<0 || nx>=n || ny>=n || visited[nx][ny]) continue;
				if (maps[nx][ny] == '1') {
					visited[nx][ny] = true;
					que.add(new int[] {nx, ny, cur[2] + 1});
					cnt++;
				}
			}
		}
		list.add(cnt);
	}
}
