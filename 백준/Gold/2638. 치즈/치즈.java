import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] cheeses;
	static boolean[][] visited;
	static int cheeseNum = 0;
	static int n, m;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static ArrayList<int[]> cheeseList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		cheeses = new int[n][m];
		cheeseList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				cheeses[i][j] = Integer.parseInt(st.nextToken());
				if (cheeses[i][j] == 1) {
					cheeseList.add(new int[] {i, j});
					cheeseNum++;
				}
			}
		}

		int time = 0;
		while (cheeseNum != 0) {
			time++;
			visited = new boolean[n][m];
			countOutSide();
			check();
		}
		System.out.println(time);

	}

	public static void countOutSide() {
		Queue<int[]> que = new LinkedList<>();
		visited = new boolean[n][m];

		que.add(new int[] {0, 0});
		visited[0][0] = true;
		cheeses[0][0] = 2;

		while (!que.isEmpty()) {
			int[] cur = que.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)continue;
				if (visited[nx][ny] || cheeses[nx][ny] == 1) continue;
				cheeses[nx][ny] = 2;
				que.add(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
	}

	public static void check() {
		for (int i = 0; i < cheeseList.size(); i++) {
			int x = cheeseList.get(i)[0];
			int y = cheeseList.get(i)[1];
			int cnt = 0;

			for (int j = 0; j < 4; j++) {
				int nx = x + dx[j];
				int ny = y + dy[j];

				if (cheeses[nx][ny] == 2)
					cnt++;
			}

			if (cnt >= 2) {
				cheeses[x][y] = 0;
				cheeseNum--;
				cheeseList.remove(i);
				i--;
			}
		}
	}
}
