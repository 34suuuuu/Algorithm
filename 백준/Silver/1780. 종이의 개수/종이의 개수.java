import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] confetties;
	static int[] colors = new int[3];	// 0:minus, 1:zero, 2:plus

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		confetties = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				confetties[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0, 0, n);

		for (int i : colors) {
			System.out.println(i);
		}
	}

	public static void solve(int x, int y, int size) {
		if (checkColor(x, y, size)) {
		// 	모두 같은 색이면
			colors[confetties[x][y] + 1]++;
			return;
		}

		size /= 3;
		solve(x, y, size);
		solve(x, y + size, size);
		solve(x, y + 2 * size, size);

		solve(x + size, y, size);
		solve(x + size, y + size, size);
		solve(x + size, y + 2 * size, size);

		solve(x + 2 * size, y, size);
		solve(x + 2 * size, y + size, size);
		solve(x + 2 * size, y + 2 * size, size);
	}

	// 사이즈 내에서 색이 다르면 false
	public static boolean checkColor(int x, int y, int size) {
		int color = confetties[x][y];

		for (int i = x; i< x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(confetties[i][j] != color) return false;
			}
		}
		return true;
	}
}
