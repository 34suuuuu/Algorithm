import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String input = br.readLine();
			if(input.equals(".")) break;

			Stack<String> stack = new Stack<>();
			String[] str = input.strip().split("");
			for (String s : str) {
				switch (s) {
					case "(":
					case"[":
						stack.push(s);
						break;
					case ")":
						if (!stack.isEmpty() && stack.peek().equals("(")) {
							stack.pop();
						} else {
							stack.push(s);
						}
						break;
					case "]":
						if (!stack.isEmpty() && stack.peek().equals("[")) {
							stack.pop();
						} else {
							stack.push(s);
						}
						break;
				}
			}
			if (stack.isEmpty()) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
