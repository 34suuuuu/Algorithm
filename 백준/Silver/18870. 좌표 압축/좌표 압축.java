import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] nums = new int[n];
		HashMap<Integer, Integer> map = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			arr[i] = nums[i];
		}
		Arrays.sort(arr);

		int rank = 0;
		for (int i : arr) {
			if (!map.containsKey(i)) {
				map.put(i, rank);
				rank++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			sb.append(map.get(nums[i]) + " ");
		}
		System.out.println(sb);


	}
}
