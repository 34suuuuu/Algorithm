import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> nums = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (nums.containsKey(num)) {
				nums.put(num, nums.get(num) + 1);
			} else {
				nums.put(num, 1);
			}
		}

		StringBuilder sb = new StringBuilder();

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(nums.get(num) == null) sb.append(0).append(" ");
			else sb.append(nums.get(num)).append(" ");
		}
		System.out.println(sb);
	}
}
