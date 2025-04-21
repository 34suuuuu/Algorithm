import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] trees = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = Arrays.stream(trees).max().getAsInt(); // 나무 높이의 최대값
		while (start < end) {
			int mid = (start + end) / 2;

			long sum = 0;
			for (int tree : trees) {
				sum += Math.max(tree - mid, 0);
			}

			if (sum < m) {    // 너무 조금 자른 경우 -> 높이는 내려야함
				end = mid;
			} else {	// 너무 많이 자른 경우 -> 높이를 올려야함
				start = mid + 1;
			}
		}
		System.out.println(start  - 1);

	}
}
