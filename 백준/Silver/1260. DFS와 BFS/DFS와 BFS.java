import java.io.*;
import java.util.*;

public class Main {
	static int N,M, V;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());	// 시작노드

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		// graph 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			graph[node1].add(node2);
			graph[node2].add(node1);
		}

		// 연결된 노드를 오름차순으로 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		sb = new StringBuilder();
		dfs(V);
		System.out.println(sb);

		visited = new boolean[N + 1];
		System.out.println(bfs(V));
	}

	static void dfs(int nodeIdx) {
		visited[nodeIdx] = true;
		sb.append(nodeIdx + " ");

		for (int node : graph[nodeIdx]) {
			if (!visited[node]) {
				dfs(node);
			}
		}
	}

	static String bfs(int start) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();

		// 현재 node값 출력문에 추가
		que.add(start);
		visited[start] = true;

		while (!que.isEmpty()) {
			int nodeIdx = que.poll();
			sb.append(nodeIdx + " ");

			for (int node : graph[nodeIdx]) {
				if (!visited[node]) {
					visited[node] = true;
					que.offer(node);
				}
			}
		}
		return sb.toString();
	}

}
