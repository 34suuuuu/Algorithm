import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] dist = new int[2000002];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		// visited 배열 없이 방문 여부를 확인하기 위해 사용
		// -1이면 아직 방문하지 않은 위치
		Arrays.fill(dist, -1);
		bfs(n);
	}

	static void bfs(int pos) {
		Queue<Integer> que = new LinkedList<>();
		que.add(pos);
		dist[pos] = 0;

		while (!que.isEmpty()) {
			int cur = que.poll();
			int next;

			if (cur == k) {
				System.out.println(dist[cur]);
				return;
			}

			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					next = cur - 1;
				} else if (i == 1) {
					next = cur + 1;
				} else {
					next = cur * 2;
				}

				if (next >= 0 && next < dist.length && dist[next] == -1) {
					que.add(next);
					dist[next] = dist[cur] + 1;
				}
			}

		}
	}
}
