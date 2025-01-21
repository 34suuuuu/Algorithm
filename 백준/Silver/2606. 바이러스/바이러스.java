import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] computers;
	static boolean[] visited;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		computers = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			computers[a][b] = computers[b][a] = 1;
		}
		dfs(1);
		System.out.println(result);
	}

	public static void dfs(int node) {
		visited[node] = true;

		for (int i = 1; i < computers[node].length; i++) {
			// 방문하지 않았고, 연결되어있다면
			if(!visited[i] && computers[node][i] == 1) {
				result++;
				dfs(i);
			}
		}
	}
}
