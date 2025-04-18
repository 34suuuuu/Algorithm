import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] maps;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		answer = new int[n + 1];

		// 신뢰 관계 초기화
		maps = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			maps[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			maps[com1].add(com2);
		}

		for (int i = 1; i <= n; i++) {
			// 방문 배열 초기화
			visited = new boolean[n + 1];
			dfs(i);
		}

		int maxValue = Arrays.stream(answer).max().getAsInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (answer[i] == maxValue) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}

	public static void dfs(int n) {
		visited[n] = true;

		for (int com : maps[n]) {
			if (!visited[com]) {
				visited[com] = true;
				answer[com]++;
				dfs(com);
			}
		}

	}
}
