import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, sx, sy, dir;
	static int result = 0;
	static int[][] maps;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maps = new int[n][m];

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		// 0: 북, 1: 동, 2: 남, 3: 서
		dir = Integer.parseInt(st.nextToken());

		// 1: 벽, 0: 청소하지 않은 칸, -1: 지나온 칸
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (maps[sx][sy] == 0) {
			maps[sx][sy] = -1;
			result++;
		}

		search(sx, sy, dir);
		System.out.println(result);
	}

	static void search(int x, int y, int dir) {
		// 	청소하지 않았다면
		if (maps[x][y] == 0) {
			maps[x][y] = -1;
			result++;
		}
		// 	방문처리하고 answer++;

		// 아직 4방면에 청소할 공간이 남은 상태
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 0) {
				flag = true;
			}
		}

		if (flag) {
			dir = changeDir(dir);
			int nx = x + dx[dir];
			int ny = y + dy[dir];

			while (maps[nx][ny] != 0) {
				dir = changeDir(dir);
				nx = x + dx[dir];
				ny = y + dy[dir];
			}
			if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 0) {
				maps[nx][ny] = -1;
				result++;

				search(nx,ny,dir);
			}
		} else {
			int nx = x - dx[dir];
			int ny = y - dy[dir];

			if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] != 1) {
				search(nx, ny, dir);
			}
		}
	}

	static int changeDir(int dir) {
		return (dir + 3) % 4;
	}
}
