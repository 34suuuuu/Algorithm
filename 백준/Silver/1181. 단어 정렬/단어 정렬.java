import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = br.readLine();
		}
		String[] uniqueWords = Arrays.stream(words)
			.distinct()
			.toArray(String[]::new);

		Arrays.sort(uniqueWords, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});

		for (String s : uniqueWords) {
			System.out.println(s);
		}

	}
}
