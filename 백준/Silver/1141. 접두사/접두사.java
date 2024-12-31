import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<String> words = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			words.add(br.readLine());
		}
		Collections.sort(words);

		int result = n;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (words.get(j).startsWith(words.get(i))) {
					result--;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
