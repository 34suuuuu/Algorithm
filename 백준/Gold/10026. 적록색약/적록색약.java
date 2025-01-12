import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[][] colors;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		colors = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				if (str[j].equals("R")) {
					colors[i][j] = 1;
				} else if (str[j].equals("G")) {
					colors[i][j] = 2;
				} else if (str[j].equals("B")) {
					colors[i][j] = 3;
				}
			}
		}

	// 	적록색약이 아닌 경우
		int result1 = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 1; k < 4; k++) {
					if (!visited[i][j] && colors[i][j] == k) {
						dfs(i, j, k);
						result1++;
					}
				}
			}
		}

	// 	적록색약인 경우
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (colors[i][j] == 1) {
					colors[i][j] = 2;
				}
			}
		}

		int result2 = 0;
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 1; k < 4; k++) {
					if (!visited[i][j] && colors[i][j] == k) {
						dfs(i, j, k);
						result2++;
					}
				}
			}
		}

		System.out.println(result1 + " " + result2);
	}
	static void dfs(int x, int y, int color) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx > n - 1 || ny > n - 1) continue;
			if (visited[nx][ny]) continue;

			if (colors[nx][ny] == color) {
				dfs(nx, ny, color);
			}
		}

	}
}
