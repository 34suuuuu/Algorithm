import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {

			int foods = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int day = 1;
			long sum = 0;

			for (int i = 0; i < 6; i++) {
				sum += Integer.parseInt(st.nextToken());
			}

			while (sum <= foods) {
				sum *= 4;
				day++;
			}

			System.out.println(day);
		}

	}
}
