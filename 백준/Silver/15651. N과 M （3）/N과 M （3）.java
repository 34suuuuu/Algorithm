import java.util.Scanner;

public class Main {
	static int n, m;
	static StringBuilder sb = new StringBuilder();

	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		result = new int[m];
		dfs(0);
		System.out.println(sb);

	}

	private static void dfs(int depth) {
		if(depth == m) {
			for (int i : result) {
				sb.append(i + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			result[depth] = i + 1;
			dfs(depth + 1);
		}
	}
}
