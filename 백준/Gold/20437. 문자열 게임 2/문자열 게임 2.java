import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			String w = br.readLine();
			int k = Integer.parseInt(br.readLine());

			if (k == 1) {
				sb.append("1 1\n");
				continue;
			}

			int min = Integer.MAX_VALUE; // 가장 짧은
			int max = Integer.MIN_VALUE;// 첫,마지막이 같은

			int[] alpha = new int[26];
			for (int i = 0; i < w.length(); i++) {
				alpha[w.charAt(i) - 'a']++;
			}

			for (int i = 0; i < w.length(); i++) {
				char start = w.charAt(i);
				int cnt = 1;

				if (alpha[start - 'a'] < k) continue;

				for (int j = i + 1; j < w.length(); j++) {
					char cur = w.charAt(j);

					if (start == cur) {
						cnt++;
					}
					if (cnt == k) {
						min = Math.min(min, j - i + 1);
						max = Math.max(max, j - i + 1);
						break;
					}
				}
			}
			if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE) {
				sb.append(-1).append("\n");
			} else {
				sb.append(min + " " + max).append("\n");
			}
		}
		System.out.println(sb);
	}
}
