import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		nums = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				nums[stack.pop()] = nums[i];
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			nums[stack.pop()] = -1;
		}

		for (int j = 0; j < n; j++) {
			sb.append(nums[j]).append(' ');
		}
		System.out.println(sb);

	}


}
