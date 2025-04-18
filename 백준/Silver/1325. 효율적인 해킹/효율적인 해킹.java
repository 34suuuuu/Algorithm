import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] maps;
	static boolean[] visited;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 신뢰 관계 초기화
		maps = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			maps[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			maps[com2].add(com1);
		}

		ArrayList<Integer> count = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			// 방문 배열 초기화
			visited = new boolean[n + 1];
			dfs(i);
			// 해킹할 수 있는 컴퓨터 갯수
			count.add(cnt);
			cnt = 0;
		}

		int maxValue = Collections.max(count);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (count.get(i) == maxValue) {
				sb.append(i + 1).append(" ");
			}
		}
		System.out.println(sb);
	}

	public static void dfs(int n) {
		visited[n] = true;

		for (int com : maps[n]) {
			if (!visited[com]) {
				cnt++;
				dfs(com);
			}
		}
	}
}
