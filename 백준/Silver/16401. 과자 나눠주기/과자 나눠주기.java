import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] cookies = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cookies[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cookies);

		int start = 1;
		int end = cookies[n - 1];

		while (start <= end) {
			int mid = (start + end) / 2;

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (cookies[i] >= mid) {
					cnt += (cookies[i] / mid);
				}
			}

			if (cnt >= m) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		System.out.println(end);
	}
}
