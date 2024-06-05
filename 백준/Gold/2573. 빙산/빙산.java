import java.io.*;
import java.util.*;

public class Main {

	static class Ice{
		int x;
		int y;

		Ice(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] maps;
	static boolean[][] visited;

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maps = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 빙하를 녹이고 -> bfs
		// 덩어리 갯수를 확인하는 -> dfs/ cntArea
		int year = 0;
		int result = cntArea();
		while (result < 2) {
			// 나눠진 덩어리가 2개 이상이라면 break;
			// 나눠진 덩어리가 0개라면 다 녹은거라서 break;
			if (result == 0) {
				year = 0;
				break;
			}

			bfs();
			year++;
			result = cntArea();
		}
		System.out.println(year);
	}

	// 빙산 덩어리 개수를 세는 메소드
	public static int cntArea() {
		visited = new boolean[N][M];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// if (!visited[i][j] && maps[i][j] > 0) {
				if (maps[i][j] != 0 && !visited[i][j]) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			if (!visited[nx][ny] && maps[nx][ny] != 0) {
				// 빙산 덩어리 => maps[x][y] != 0
				dfs(nx, ny);
			}
		}
	}


	// 빙하 녹이기
	// 상하좌우에서 0이 아니면 큐에 담아주고 몇개의 0으로 둘러쌓였는지 확인해서 maps 갱신
	static void bfs() {
		Queue<Ice> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maps[i][j] != 0) {
					que.add(new Ice(i, j));
					visited[i][j] = true;
				}
			}
		}

		while (!que.isEmpty()) {
			Ice ice = que.poll();
			int ice_x = ice.x;
			int ice_y = ice.y;
			int zeroCnt = 0; // 상하좌우에 바닷물에 접해있는 부분의 면적을 세기 위해서

			for (int i = 0; i < 4; i++) {
				int nx = ice_x + dx[i];
				int ny = ice_y + dy[i];

				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if (!visited[nx][ny] && maps[nx][ny] == 0) {
					//빙하 => maps[nx][ny] == 0
					zeroCnt++;
				}
			}

			// 주변 바닷물 면적 구해서 빙하 녹이기
			if (maps[ice_x][ice_y] - zeroCnt < 0) {
				maps[ice_x][ice_y] = 0;
			} else {
				maps[ice_x][ice_y] -= zeroCnt;
			}
		}
	}

	static void printMaps(){
		for (int[] i : maps) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

