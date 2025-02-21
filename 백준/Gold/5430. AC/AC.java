import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static Deque<Integer> deque;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());

			deque = new ArrayDeque<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(st.nextToken()));
			}
			System.out.println(AC(command));
		}
	}

	public static String AC(String command) {
		boolean reverse = false;

		for(char c : command.toCharArray()) {
			if (c == 'R') {
				reverse = !reverse;
			}else{
				if (deque.size() == 0) {
					return "error";
				}
				if (reverse) {
					deque.removeLast();
				} else {
					deque.removeFirst();
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append("[");
		while (!deque.isEmpty()) {
			if (reverse) {
				sb.append(deque.removeLast());
			}else{
				sb.append(deque.removeFirst());
			}

			if (deque.size() != 0) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
