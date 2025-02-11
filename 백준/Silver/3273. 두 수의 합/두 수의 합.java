import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		int x = Integer.parseInt(br.readLine());

		int start = 0, end = n - 1;
		int cnt = 0;
		while (start < end) {
			if(nums[start] + nums[end] == x) {
				cnt++;
				start++;
			}
			else if(nums[start] + nums[end] < x) start++;
			else end--;
		}
		System.out.println(cnt);
	}
}
