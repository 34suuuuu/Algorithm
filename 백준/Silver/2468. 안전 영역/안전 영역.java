import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static int[][] maps;
	static boolean[][] visited;

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		maps = new int[N][N];
		int maxHeight = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int height = Integer.parseInt(st.nextToken());
				maxHeight = Math.max(height, maxHeight);
				maps[i][j] = height;
			}
		}

		int maxArea = Integer.MIN_VALUE;

		for (int height = 0; height <= maxHeight; height++) {
			visited = new boolean[N][N];
			int area = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && maps[i][j] > height) {
						area++;
						dfs(i,j,height);
					}
				}
			}
			maxArea = Math.max(area, maxArea);
		}
		System.out.println(maxArea);
	}

	static void dfs(int x, int y, int height) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >=N || ny < 0 || ny >= N) continue;
			if (!visited[nx][ny] && maps[x][y] > height) {
				dfs(nx, ny, height);
			}
		}
	}
}