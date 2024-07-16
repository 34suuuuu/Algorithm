import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Position{
	int x,y;

	Position(int x, int y ) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static char[][] maps;
	static int n,m, answer;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static Position start;
	static Queue<Position> fires;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		for(int test_case = 0; test_case < t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			maps = new char[m][n];
			fires = new LinkedList<>();
			answer = 0;

			start = new Position(0, 0);
			for (int i = 0; i < m; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					maps[i][j] = str.charAt(j);
					if (str.charAt(j) == '@') {
						// 시작지점
						start.x = i;
						start.y = j;
					} else if (maps[i][j] == '*') {
						// 불
						fires.add(new Position(i, j));
					}
				}
			}
			fires.add(new Position(start.x, start.y));
			sb.append(bfs() ? answer : "IMPOSSIBLE").append("\n");
		}
		System.out.println(sb);
	}

	static boolean bfs() {

		while(!fires.isEmpty()) {
			answer++;
			int size = fires.size();
			for (int s = 0; s < size; s++) {
				Position cur = fires.poll();

				for (int i = 0; i < 4; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (nx < 0 || nx >= m || ny < 0 || ny >= n){
						if(maps[cur.x][cur.y]  == '@') return true;
						continue;
					}
					if(maps[nx][ny] != '.') continue;
					maps[nx][ny] = maps[cur.x][cur.y];
					fires.add(new Position(nx, ny));
				}
			}
		}
		return false;
	}

}
