import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}
		words = Arrays.stream(words).distinct().toArray(String[]::new);

		Arrays.sort(words, (o1,o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}else
				return o1.length() - o2.length();
		} );

		StringBuilder sb = new StringBuilder();
		for (String s : words) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}
}
