import java.io.*;
import java.util.*;

public class Main {

	static int N,M, K;
	static int[][] maps;
	static boolean[][] visited;
	static int cnt;

	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		maps = new int[M][N];
		ArrayList<Integer> result = new ArrayList<>();

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			makeRec(x1, y1, x2, y2);
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
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
		for (int y = y1; y < y2; y++) {
			for (int x = x1; x < x2; x++) {
				maps[y][x] = 1;
			}
		}

	}

	static void bfs(int y, int x) {
		maps[y][x] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || nx >=N || ny < 0 || ny >= M) continue;
			if (maps[ny][nx] == 0) {
				cnt++;
				bfs(ny,nx);
			}
		}

	}
}
