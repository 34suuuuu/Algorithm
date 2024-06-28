import java.io.*;
import java.util.*;

public class Main {
	static int[][] maps;
	static boolean[][]visited;
	static int n, m, result;
	static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
	static int[] dy = {1, -1, 0, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maps = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (maps[i][j] == 0) {
                    visited = new boolean[n][m];
					result = Math.max(result, bfs(i, j));
				}
			}
		}
		System.out.println(result);
	}

	static int bfs(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(x, y, 0));
		visited[x][y] = true;

		while(!que.isEmpty()) {
			Node cur = que.poll();
			visited[cur.x][cur.y] =  true;

			for (int i = 0; i < 8; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if(nx < 0 || ny< 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

				if (maps[nx][ny] == 1) {
					return cur.dist + 1;
				}
				
				visited[nx][ny] = true;
				que.add(new Node(nx, ny, cur.dist + 1)); // 상어만나는게 아니면 계속 distance+1 해주면서 값 갱신
			}
		}
		return 0;
	}
}

class Node {
	int x;
	int y;
	int dist;

	Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
