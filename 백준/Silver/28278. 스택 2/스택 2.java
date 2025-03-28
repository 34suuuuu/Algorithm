import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			switch (command) {
				case 1:
					int num = Integer.parseInt(st.nextToken());
					stack.add(num);
					break;
				case 2:
					sb.append(stack.isEmpty() ? "-1" : stack.pop()).append("\n");
					break;
				case 3:
					sb.append(stack.size()).append("\n");
					break;
				case 4:
					sb.append(stack.isEmpty() ? "1" : "0").append("\n");
					break;
				case 5:
					sb.append(stack.isEmpty() ? "-1" : stack.peek()).append("\n");
					break;
			}
		}
		System.out.println(sb);

	}
}
