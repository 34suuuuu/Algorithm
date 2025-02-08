import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,k;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[k];

		dfs(1, 0);
	}

	public static void dfs(int num, int depth) {
		if (depth == k) {
			for (int i : arr) {
				System.out.print(i+ " ");
			}
			System.out.println();
			return;
		}

		for (int i = num; i <= n; i++) {
			arr[depth] = i;
			dfs(i, depth + 1);
		}
	}
}
