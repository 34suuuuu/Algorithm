import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int answer = str.length();

		for (int i = 0; i < str.length(); i++) {
			String tmp = str.substring(i);
			if(isPalindrome(tmp)){
				break;
			}
			answer++;
		}
		System.out.println(answer);
	}

	public static boolean isPalindrome(String s) {
		int start = 0, end = s.length() - 1;

		while (start < end) {
			if(s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
