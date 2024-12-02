import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int L,C, cnt;
	static char[] alphabet;
	static char[] passwords;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alphabet = br.readLine().replace(" ", "").toCharArray();
		passwords = new char[L];
		Arrays.sort(alphabet);

		dfs(0, 0);

	}

	static void dfs(int start, int cnt) {
		if (cnt == L) {
			if (isValid(passwords)) {
				System.out.println(passwords);
			}
			return;
		}
		for (int i = start; i < C; i++) {
			passwords[cnt] = alphabet[i];
			dfs(i + 1, cnt + 1);
		}

	}

	public static boolean isValid(char[] password){
		int vowels = 0;	// 모음
		int consonants = 0;	// 자음

		for (char c : password) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vowels++;
			} else {
				consonants++;
			}
		}

		if (vowels >= 1 && consonants >= 2) {
			return true;
		}
		return false;
	}
}
