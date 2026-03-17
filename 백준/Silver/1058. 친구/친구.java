import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static char[][] friends;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		friends = new char[n][n];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			friends[i] = str.toCharArray();
		}

		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			answer = Math.max(answer, bfs(i));
		}

		System.out.println(answer);

	}

	public static int bfs(int idx){
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[n];

		que.add(idx);
		visited[idx] = true;

		int depth = 0;
		int cnt = 0;

		while(depth < 2){
			int size = que.size();
			for(int i = 0; i < size; i++){
				int cur = que.poll();

				for (int j = 0; j < n; j++) {
					if(friends[cur][j] == 'Y' && !visited[j]){
						que.add(j);
						visited[j] = true;
						cnt++;
					}
				}
			}
			depth++;
		}
		return cnt;
	}
}
