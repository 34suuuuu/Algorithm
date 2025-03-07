import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Deque<Integer> que = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
				case "push":
					int num = Integer.parseInt(st.nextToken());
					que.add(num);
					break;
				case "pop":
					sb.append(que.isEmpty() ? "-1" : que.poll()).append("\n");
					break;
				case "size":
					sb.append(que.size()).append("\n");
					break;
				case"empty":
					sb.append(que.isEmpty() ? "1" : "0").append("\n");
					break;
				case "front":
					sb.append(que.isEmpty() ? "-1" : que.getFirst()).append("\n");
					break;
				case "back":
					sb.append(que.isEmpty() ? "-1" : que.getLast()).append("\n");
					break;
			}
		}

		System.out.println(sb);
	}
}
