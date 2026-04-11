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
		int[] times = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		}

		if (n % 2 == 1) {
			System.out.println(1);
		}else{
			Arrays.sort(times);
			System.out.println(Math.abs(times[n / 2] - times[n / 2 - 1] + 1));
		}
	}
}
