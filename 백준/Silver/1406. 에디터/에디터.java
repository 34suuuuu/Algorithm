import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<Character> left;
	static Stack<Character> right;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		left = new Stack<>();
		right = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));
		}

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			switch (cmd) {
				case 'L':
					if (!left.isEmpty()) {
						right.push(left.pop());
					}
					break;
				case 'D':
					if (!right.isEmpty()) {
						left.push(right.pop());
					}
					break;
				case 'B':
					if (!left.isEmpty()) {
						left.pop();
					}
					break;
				case 'P':
					char c = st.nextToken().charAt(0);
					left.push(c);
					break;
			}
		}
		while (!left.isEmpty()) {
			right.push(left.pop());
		}
		StringBuilder sb = new StringBuilder();
		while (!right.isEmpty()) {
			sb.append(right.pop());
		}
		System.out.println(sb);
	}
}

