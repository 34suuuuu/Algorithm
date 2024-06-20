import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int in = Integer.parseInt(st.nextToken());
			if (in != 0) {
				stack.push(in);
			} else {
				stack.pop();
			}
		}

		int result = stack.stream().reduce(0, (a, b) -> a + b);
		System.out.println(result);

	}
}
