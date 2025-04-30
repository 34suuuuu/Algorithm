import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<String> wordList = new ArrayList<>();
		String input = br.readLine();
		for (int a = 1; a < input.length(); a++) {
			for (int b = a+1; b < input.length(); b++) {
				String str1 = input.substring(0, a);
				String str2 = input.substring(a, b);
				String str3 = input.substring(b);

				StringBuilder sb = new StringBuilder();
				wordList.add(sb.append(flipWord(str1)).append(flipWord(str2)).append(flipWord(str3)).toString());
			}
		}
		Collections.sort(wordList);
		System.out.println(wordList.get(0));
	}

	private static String flipWord(String word) {
		StringBuilder sb = new StringBuilder();
		for(int i = word.length()-1; i >= 0; i--){
			sb.append(word.charAt(i));
		}
		return sb.toString();
	}
}
