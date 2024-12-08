import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int[] sensors = new int[n];
		int[] diff = new int[n - 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensors);

		for (int i = 1; i < n; i++) {
			diff[i - 1] = sensors[i] - sensors[i - 1];
		}
		Arrays.sort(diff);

		int sum = 0;
		for (int i = 0; i < n - k; i++) {
			sum += diff[i];
		}

		System.out.println(sum);
	}
}
