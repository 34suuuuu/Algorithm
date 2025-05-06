import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R,C;
	static char[][] board;
	static boolean[] visited;	// 알파벳 방문 여부 확인
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int answer = Integer.MIN_VALUE;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		visited = new boolean[26];

		// 좌측 상단칸 방문처리
		visited[board[0][0] - 65] = true;
		answer++;

		dfs(0, 0, 1);
		System.out.println(answer);

	}

	private static void dfs(int x, int y, int result){
		answer = Integer.max(answer, result);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i]; //0
			int ny = y + dy[i]; //5

			if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
				char nc = board[nx][ny];

				// 방문하지 않았다면 방문처리
				if(!visited[nc - 65]){
					visited[nc - 65] = true;
					dfs(nx, ny, result + 1);
					visited[nc - 65] = false;
				}
			}
		}
	}
}
