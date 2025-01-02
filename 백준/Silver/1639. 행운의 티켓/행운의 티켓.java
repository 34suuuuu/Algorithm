import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int len = str.length();
		int max = 0;

		for (int i = 1; i <= len / 2; i++) {
			for (int j = 0; j <= len - 2 * i; j++) {
				int left= 0;
				int right = 0;

				for (int k = j; k < j + i; k++) {
					left += str.charAt(k) - '0';
				}

				for (int k = i + j; k < j + 2 * i; k++) {
					right += str.charAt(k) - '0';
				}
				if (left == right) {
					max = Math.max(max, 2 * i);
				}
			}
		}
		System.out.println(max);



	}
}
