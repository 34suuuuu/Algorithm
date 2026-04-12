import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int test_case = Integer.parseInt(st.nextToken());
		for (int t = 0; t < test_case; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 문서의 갯수
			int m = Integer.parseInt(st.nextToken()); // 궁금한 문서의 순서

			Queue<int[]> que = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				que.add(new int[]{i, Integer.parseInt(st.nextToken())});
			}

			int cnt = 0;
			while (true) {
				int[] cur = que.poll();
				boolean chk = true;

				for (int[] q : que) {
					if(q[1] > cur[1]){
						chk = false;
						break;
					}
				}

				if(chk){
					cnt++;
					if(cur[0] == m) break;
				}else{
					que.add(cur);
				}
			}
			System.out.println(cnt);
		}
	}
}
