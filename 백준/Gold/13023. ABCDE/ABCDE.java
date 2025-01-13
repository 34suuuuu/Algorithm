import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m, result = 0;
	static ArrayList<Integer>[] friends;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		friends = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			friends[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];
			dfs(i, 1);
			if (result == 1) {
				System.out.println(1);
				return;
			}
		}
		System.out.println(0);
	}

	public static void dfs(int idx, int depth) {
		if (depth == 5) {
			result = 1;
			return;
		}

		for(int friend : friends[idx]) {
			if (!visited[friend]) {
				visited[idx] = true;
				dfs(friend, depth + 1);
				visited[idx] = false;
			}
		}
	}
}
