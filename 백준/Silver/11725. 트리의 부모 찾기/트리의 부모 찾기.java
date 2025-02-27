import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> tree;
	static boolean[] visited;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		tree = new ArrayList<>();
		parent = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			tree.get(start).add(end);
			tree.get(end).add(start);	// 연결지점 설정
		}

		bfs(1);
		for (int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}


	}

	public static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start] = true;

		while (!que.isEmpty()) {
			int cur = que.poll();
			for (int node : tree.get(cur)) {
			// 	연결된 노드들 확인
				if (!visited[node]) {
				// 	방문하지 않았다면
					visited[node] = true;
					que.add(node);
					parent[node] = cur;
				}
			}
		}
	}
}
