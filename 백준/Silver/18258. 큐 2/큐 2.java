import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Deque<Integer> deque = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num;
			if (cmd.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				deque.add(num);
			}else if (cmd.equals("pop")) {
				sb.append(deque.isEmpty() ? -1 : deque.poll()).append("\n");
			}else if (cmd.equals("size")) {
				sb.append(deque.size()).append("\n");
			} else if (cmd.equals("empty")) {
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
			} else if (cmd.equals("front")) {
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
			}else if (cmd.equals("back")) {
				sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");			} else {
			}
		}
		System.out.println(sb);

	}
}
