import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		ArrayList<Integer> buttons = new ArrayList<>();
		if (m != 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int button = Integer.parseInt(st.nextToken());
				buttons.add(button);
			}
		}

		int answer = Math.abs(100 - n);
		for (int i = 0; i <= 999999; i++) {
			String str = String.valueOf(i);
			boolean chk = false;

			for (int j = 0; j < str.length(); j++) {
				if (buttons.contains(str.charAt(j) - '0')) {
					chk = true;    // 고장났으면 false
					break;
				}
			}
			if (!chk) {
				answer = Math.min(answer, str.length() + Math.abs(n - i));
			}
		}
		System.out.println(answer);
	}
}
