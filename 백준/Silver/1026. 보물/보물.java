import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Integer[] A = new Integer[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		Integer[] B = new Integer[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());

		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += A[i] * B[i];
		}
		System.out.println(sum);
	}
}
