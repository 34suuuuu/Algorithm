import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] nums;
	static int[] result;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n  = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		result = new int[m];

		dfs(0, 0);

	}

	private static void dfs(int depth, int idx) {
		if (depth == m) {
			for (int i : result) {
				System.out.print(i+ " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				result[idx] = nums[i];
				visited[i] = true;
				dfs(depth + 1, idx + 1);
				visited[i] = false;
			}

		}

	}
}
