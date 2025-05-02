import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] stats;
	static boolean[] visited;
	static int[] nums;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stats = new int[n][n];
		visited = new boolean[n];
		nums = new int[n / 2];

		// 능력치 초기화
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 3개씩 나누는 조합을 구하기 -> 백트래킹
		// 	조합별로 능력치 구해서 차이 빼기
		// 	그게 MIN값인지 확인 후 값 갱신

		backTracking(0, 0);
		System.out.println(result);
	}

	private static void backTracking(int depth, int idx) {
		if(depth == n/2){
			getDiff();
			return;
		}

		for (int i = idx; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				backTracking(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	private static void getDiff() {
		int start = 0, link = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if (visited[i] && visited[j]) {
					start += (stats[i][j] + stats[j][i]);
				}else if(!visited[i] && !visited[j]) {
					link += (stats[i][j] + stats[j][i]);
				}
			}
		}
		int diff = Math.abs(start - link);
		if (diff == 0) {
		// 	이미 0이면
			System.out.println(diff);
			System.exit(0);
		}
		result = Math.min(result, diff);
	}
}
