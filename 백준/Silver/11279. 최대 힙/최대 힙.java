import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.peek()).append("\n");
					pq.poll();
				}
			} else {
				pq.add(x);
			}
		}
		System.out.println(sb);
	}
}
