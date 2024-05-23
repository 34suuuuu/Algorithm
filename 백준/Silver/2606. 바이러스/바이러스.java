import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,connection, cnt;
	static List[] computers;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		cnt = -1;
		N = Integer.parseInt(br.readLine());
		connection = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		computers = new List[N + 1];
		for (int i = 1; i < N + 1; i++) {
			computers[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < connection; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			computers[a].add(b);
			computers[b].add(a);
		}
		bfs(1);
		System.out.println(cnt);
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (!visited[cur]) {
				++cnt;
				visited[cur] = true;
				for (int i = 0; i < computers[cur].size(); i++) {
					queue.add((int)computers[cur].get(i));
				}
			}
		}
	}
}
