import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder s = new StringBuilder(br.readLine());
		StringBuilder t = new StringBuilder(br.readLine());

		while (t.length() > s.length()) {
			char c = t.charAt(t.length() - 1);
			if (c == 'A') {
				t.deleteCharAt(t.length() - 1);
			} else {
				t.deleteCharAt(t.length() - 1);
				t.reverse();
			}
		}
		System.out.println(s.toString().equals(t.toString()) ? 1 : 0);
	}
}
