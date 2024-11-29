import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int[] lines = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			lines[i] = Integer.parseInt(st.nextToken());
		}
		int[] answer = new int[n];
		Arrays.fill(answer, 0);

		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (cnt == lines[i] && answer[j] == 0) {
					answer[j] = i + 1;
					break;
				} else if (answer[j] == 0) {
					cnt++;
				}
			}
		}
		for (int i : answer) {
			System.out.print(i+" ");
		}
	}
}
