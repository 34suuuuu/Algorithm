import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(br.readLine());

		int minVal = Math.abs(A - B);

		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			minVal = Math.min(minVal, Math.abs(B - num) + 1);
		}
		System.out.println(minVal);
	}
}
