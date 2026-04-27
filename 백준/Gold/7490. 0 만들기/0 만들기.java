import java.util.Scanner;

public class Main {
	static int n;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			n = sc.nextInt();
			sb = new StringBuilder();
			backtracking(1,  1,1, 0, "1");
			System.out.println(sb);
		}
	}

	private static void backtracking(int cur, int num, int sign, int sum, String str) {
		// System.out.println("=====" + cur + " " + num + " " + sign + " " + sum + "=====");
 		if (cur == n) {
			if (sum + sign * num == 0) {
				sb.append(str).append('\n');
			}
			return;
		}
		backtracking(cur + 1, num * 10 + (cur + 1), sign, sum, str + " " + String.valueOf(cur + 1)); // 연결
		backtracking(cur + 1, cur + 1, 1, sum + (sign * num), str + "+" + String.valueOf(cur+1)); // +
		backtracking(cur + 1, cur + 1, -1, sum + (sign * num), str + "-" + String.valueOf(cur+1)); // -
	}
}
