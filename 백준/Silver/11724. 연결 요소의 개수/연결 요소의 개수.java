import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] connections;
	static boolean[] visited;
	static int n, m;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m  = Integer.parseInt(st.nextToken());
		connections = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			connections[a][b] = 1;
			connections[b][a] = 1;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				bfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start] = true;

		while (!que.isEmpty()) {
			int cur = que.poll();

			for (int i = 1; i <= n; i++) {
				if(!visited[i] && connections[cur][i] == 1) {
					que.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
