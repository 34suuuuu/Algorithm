import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(st.nextToken());

		while (t-- > 0) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();

			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '(') {
					stack.push(str.charAt(j));
				}else {
					//비어있는지를 먼저 본다.
					if(stack.empty()) {
						stack.push(str.charAt(j));
						break;
					}else {
						stack.pop();
					}
				}
			}
			if (stack.empty()) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}
		System.out.println(sb);
	}
}
