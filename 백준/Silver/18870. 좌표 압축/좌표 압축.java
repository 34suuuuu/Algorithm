import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int cur = Integer.parseInt(st.nextToken());
			nums[i] = cur;
		}

		int[] sorted_nums = nums.clone();
		Arrays.sort(sorted_nums);

		HashMap<Integer, Integer> maps = new HashMap<>();
		int idx = 0;
		for (int num : sorted_nums) {
			if(!maps.containsKey(num)) {
				maps.put(num, idx++);
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int num : nums) {
			sb.append(maps.get(num)).append(" ");
		}
		System.out.println(sb);
	}
}
