import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<Character> stack;
		while (true) {
			stack = new Stack<>();
			String str = br.readLine();
			if (str.equals("."))
				break;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == '(' || c == '[') {
					stack.push(c);
				} else if (c == ')') {
					if (stack.isEmpty()) {
						stack.push(c);
					}
					else if (stack.peek() == '(') {
						stack.pop();
					} else {
						stack.push(c);
					}
				} else if (c == ']') {
					if (stack.isEmpty()) {
						stack.push(c);
					}
					else if (stack.peek() == '[') {
						stack.pop();
					} else {
						stack.push(c);
					}
				}
			}
			sb.append(stack.isEmpty()?"yes":"no").append("\n");
		}
		System.out.println(sb);

	}
}
