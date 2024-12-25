import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] result;
	static int[][] original;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		result = new int[n][m];    // 결과 행렬
		original = new int[n][m];    // 원본 행렬

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				original[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				result[i][j] = str.charAt(j) - '0';
			}
		}

		int cnt = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				if (original[i][j] != result[i][j]) {
					chaneNum(i, j);
					cnt++;
				}
			}
		}
		System.out.println(chkEqual() ? cnt : -1);
	}

	public static void chaneNum(int x, int y) {
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				original[i][j] = original[i][j] == 0 ? 1 : 0;
			}
		}
	}

	public static boolean chkEqual() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (result[i][j] != original[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
