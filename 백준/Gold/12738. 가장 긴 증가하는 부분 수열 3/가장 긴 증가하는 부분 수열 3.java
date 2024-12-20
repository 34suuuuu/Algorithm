import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static List<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		nums = new int[n];
		result = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		result.add(nums[0]);

		for (int i = 1; i < n; i++) {
			if (result.get(result.size() - 1) < nums[i]) {
				result.add(nums[i]);
			} else {
				binarySearch(i);
			}
		}
		System.out.println(result.size());
	}
	public static void binarySearch(int num) {
		int start = 0;
		int end = result.size() - 1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (nums[num] <= result.get(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		result.set(start, nums[num]);
	}
}
