import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < test_case; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			double dist = Math.sqrt(Math.pow((double) x1 - x2, 2) + Math.pow((double) y1 - y2, 2));
			int sum = r1 + r2;
			int sub = r1 > r2 ? r1 - r2 : r2 - r1;

			int answer = -1;

			if(dist == 0 && r1 == r2) answer = -1;
			else if(dist < sub) answer = 0;
			else if(dist > sum) answer = 0;
			else if(dist == sub) answer = 1;
			else if(dist == sum) answer = 1;
			else answer = 2;
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
