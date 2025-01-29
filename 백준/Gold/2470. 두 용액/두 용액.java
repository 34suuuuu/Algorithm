import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] liquid = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(liquid);

		int start = 0, end = n - 1;
		int min = Integer.MAX_VALUE;

		int result1 = 0, result2 = 0;
		while(start < end) {
			int sum = liquid[start] + liquid[end];

			if (min > Math.abs(sum)) {
				result1 = liquid[start];
				result2 = liquid[end];
				min = Math.abs(sum);
			}
			if (sum < 0) {
				start++;
			} else {
				end--;
			}
		}

		System.out.println(result1 + " " + result2);
	}
}
