import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Deque<Integer> deque = new LinkedList<>();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			deque.add(i + 1);
		}
		while (deque.size() > 1) {
			deque.poll();
			int tmp = deque.poll();
			deque.addLast(tmp);
		}
		System.out.println(deque.poll());
	}
}
