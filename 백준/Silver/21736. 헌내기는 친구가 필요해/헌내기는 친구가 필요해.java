import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, meetingPerson = 0;
	static char[][] maps;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maps = new char[n][m];
		visited = new boolean[n][m];

		int start_x = 0, start_y = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				maps[i][j] = str.charAt(j);

				if (maps[i][j] == 'I') {// 도연이의 초기 위치
					start_x = i;
					start_y = j;
				}
			}
		}
		dfs(start_x, start_y);
		System.out.println(meetingPerson == 0 ? "TT" : meetingPerson);

	}

	// private static void dfs(int x, int y) {
	// 	visited[x][y] = true;
	//
	// 	if (maps[x][y] == 'P') {
	// 		meetingPerson++;
	// 	}
	//
	// 	for (int i = 0; i < 4; i++) {
	// 		int nx = x + dx[i];
	// 		int ny = y + dy[i];
	//
	// 		if(nx < 0 || nx >= n || ny < y || ny >= m || visited[nx][ny] || maps[nx][ny] == 'X') continue;
	//
	// 		if (nx > 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
	// 			// 범위내에 있는 방문하지 않은 지점
	//
	// 			if (maps[nx][ny] != 'X') {
	// 				dfs(nx, ny);
	// 			}
	// 		}
	//
	// 		dfs(nx, ny);
	// 	}
	// }
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		if(maps[x][y]=='P') meetingPerson++;

		for (int i = 0; i < 4; i++) {
			int cx = x + dx[i];
			int cy = y + dy[i];

			if (cx >= 0 && cy >= 0 && cx < n && cy < m ) {
				if (!visited[cx][cy] && maps[cx][cy] != 'X') {
					dfs(cx, cy);
				}
			}
		}
	}
}
