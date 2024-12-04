import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int n;
	static int result;
	static int[] queens;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		queens = new int[n];

		backTracking(0);
		System.out.println(result);
	}

	static void backTracking(int cnt) {
		if (cnt == n) {
			result++;
			return;
		}

		for (int i = 0; i < n; i++) {
			queens[cnt] = i;
			if (isValid(cnt)) {
				backTracking(cnt + 1);
			}
		}
	}

	static boolean isValid(int col) {
		for (int i = 0; i < col; i++) {
			if (queens[col] == queens[i]) {
				return false;
			} else if (Math.abs(col - i) == Math.abs(queens[col] - queens[i])) {
				return false;
			}
		}
		return true;
	}
}