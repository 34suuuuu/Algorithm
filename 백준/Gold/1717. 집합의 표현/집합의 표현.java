import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		nums = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			nums[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (command == 0) {	// 결합
				union(a, b);
			} else if (command == 1) {	// 포함여부
				if(find(a) == find(b)) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}

	public static int find(int x) {
		if (x == nums[x]) {
			return x;
		}
		return nums[x] = find(nums[x]);
	}

	public static void union(int x, int y) {
		x = find(x);	// 최상단 부모 찾아오기
		y = find(y);
		if (x < y) {
			nums[y] = x;
		}else{
			nums[x] = y;
		}
	}
}
