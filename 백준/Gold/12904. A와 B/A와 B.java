import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();

		while (t.length() > s.length()) {
			char c = t.charAt(t.length() - 1);
			if (c == 'A') {
				t = t.substring(0, t.length() - 1);
			} else {
				t = t.substring(0, t.length() - 1);
				t = reverse(t);
			}
		}
		System.out.println(s.equals(t) ? 1 : 0);
	}

	static String reverse(String s) {
		String answer = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			answer += s.charAt(i);
		}
		return answer;
	}
}
