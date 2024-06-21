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
			int cmd = Integer.parseInt(st.nextToken());
			int num;
			if (cmd == 1) {
				num = Integer.parseInt(st.nextToken());
				deque.offerFirst(num);
			} else if (cmd == 2) {
				num = Integer.parseInt(st.nextToken());
				deque.offerLast(num);
			} else if (cmd == 3) {
				sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
			} else if (cmd == 4) {
				sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
			} else if (cmd == 5) {
				sb.append(deque.size()).append("\n");
			} else if (cmd == 6) {
				sb.append(deque.isEmpty() ? 1 :0).append("\n");
			}else if (cmd == 7) {
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
			} else {
				sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
			}
		}
		System.out.println(sb);
	}
}
