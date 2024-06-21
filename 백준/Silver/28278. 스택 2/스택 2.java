import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int num;
			if (cmd == 1) {
				num = Integer.parseInt(st.nextToken());
				stack.push(num);
			} else if (cmd == 2) {
				sb.append((stack.isEmpty() ? -1 : stack.pop())).append("\n");
			} else if (cmd == 3) {
				sb.append(stack.size()).append("\n");
			} else if (cmd == 4) {
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
			} else {
				sb.append((stack.isEmpty() ? -1 : stack.peek())).append("\n");
			}
		}
		System.out.println(sb);
		
	}
}
