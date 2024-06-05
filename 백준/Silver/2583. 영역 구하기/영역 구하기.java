import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N,M, K;
	static int[][] maps;
	static int cnt;

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		maps = new int[N][M];
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			makeRec(x1, y1, x2, y2);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maps[i][j] == 0) {
					cnt = 1;
					bfs(i, j);
					result.add(cnt);
				}
			}
		}

		Collections.sort(result);

		StringBuilder sb = new StringBuilder();
		for (Integer i : result) {
			sb.append(i + " ");
		}
		System.out.println(result.size());
		System.out.println(sb);
	}

	// 입력받은 직사각형 구역을 1로 처리
	static void makeRec(int x1, int y1, int x2, int y2) {
		for (int x = x1; x < x2; x++) {
			for (int y = y1; y < y2; y++) {
				maps[y][x] = 1;
			}
		}

	}

	static void bfs(int x, int y) {
		maps[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >=N || ny < 0 || ny >= M) continue;
			if (maps[nx][ny] == 0) {
				cnt++;
				bfs(nx,ny);
			}
		}

	}
}
