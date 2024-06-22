import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		Stack<Integer> stack = new Stack<>();
		Queue<Integer> que = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			que.offer(Integer.parseInt(st.nextToken()));
		}

		int start = 1;
		while (!que.isEmpty()) {
			if (que.peek() == start) {
				que.poll();
				start ++;
			} else if (!stack.isEmpty() && stack.peek() == start) {
				stack.pop();
				start++;
			} else {
				stack.push(que.poll());
			}
		}
		while (!stack.isEmpty()) {
			if (stack.peek() == start) {
				stack.pop();
				start++;
			} else {
				System.out.println("Sad");
				return;
			}
		}
		System.out.println("Nice");
	}
}
