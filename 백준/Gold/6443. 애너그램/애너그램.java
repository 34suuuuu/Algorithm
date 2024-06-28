import java.io.*;
import java.util.*;

public class Main {
	static int[] alphabet;
	static char[] result;
	static StringBuilder sb;
	static TreeSet<String> ts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		while (n-- > 0) {
			String input = br.readLine();
			alphabet = new int[26];
			ts = new TreeSet<>();
			result = new char[input.length()];


			for (int i = 0; i < input.length(); i++) {
				alphabet[input.charAt(i) - 'a']++;
			}

			dfs(input.length(), 0);
			for (String s : ts) {
				sb.append(s).append("\n");
			}
		}
		System.out.println(sb);
	}

	static void dfs(int size , int depth) {
		if (size == depth) {
			// 문자열의 길이와 dfs반복 횟수가 같아지면 종료
			String tmp = "";
			for (char c : result) {
				tmp += c;
			}
			ts.add(tmp);
			return;
		}

		for (int i = 0; i < 26; i++) {
			if (alphabet[i] > 0) {
				alphabet[i]--;
				result[depth] = (char)(i + 'a');
				dfs(size, depth+1);
				alphabet[i]++;
				result[depth] = ' ';
			}
		}

	}
}
