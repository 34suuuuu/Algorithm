import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> que = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			que.add(i);
		}

		int idx = 1;
		while(!que.isEmpty()) {
			if(idx == K){
				result.add(que.poll());
				idx = 1;
			}else {
				idx++;
				que.add(que.poll());
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (Integer i : result) {
			if (result.get(N - 1) != i) {
				sb.append(i + ", ");
			} else {
				sb.append(i);
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
}
