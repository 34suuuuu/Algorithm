import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		Deque<Integer> deque = new LinkedList<>();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			deque.add(i + 1);
		}

		sb.append("<");
		while (deque.size() > 1) {
			for (int i = 0; i < k-1; i++) {
				int tmp = deque.poll();
				deque.addLast(tmp);
			}
			sb.append(deque.poll()).append(", ");
		}
		sb.append(deque.poll());
		sb.append(">");
		System.out.println(sb);
	}
}
