import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
	static int[] nums;
	static boolean[] visited;
	static int n, m;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 n = sc.nextInt();
		 m = sc.nextInt();

		visited = new boolean[n];
		nums = new int[m];
		dfs(0);
		System.out.println(sb);


	}

	public static void dfs(int depth) {
		if (depth == m) {
			for (int num : nums) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				nums[depth] = i + 1;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
