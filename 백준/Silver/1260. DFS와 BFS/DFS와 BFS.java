import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[][] graph;
	static int n,m, v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		graph = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		visited = new boolean[n + 1];
		dfs(v);
		System.out.println();
		visited = new boolean[n + 1];
		bfs(v);
	}

	static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");

		for (int i = 1; i <= n; i++) {
			if (graph[start][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start] = true;
		System.out.print(start + " ");

		while(!que.isEmpty()) {
			int cur = que.poll();
			for (int i = 1; i <= n; i++) {
				if (graph[cur][i] == 1 && !visited[i]) {
					que.add(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}
