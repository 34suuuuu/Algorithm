import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static final int maxVal = 9999;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sugar = sc.nextInt();

		if(sugar<5) {
			if(sugar==3) System.out.println(1);
			else
				System.out.println(-1);
			return;
		}
		
		int[] dp = new int[sugar + 1];
		Arrays.fill(dp, maxVal);
		dp[3] = dp[5] = 1;

		for (int i = 6; i < sugar + 1; i++) {
			dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
		}

		System.out.println(dp[sugar] > maxVal ? -1 : dp[sugar]);
		//
		// int result = 0;
		// while (sugar > 0) {
		// 	if (sugar < 3) {
		// 		System.out.println(-1);
		// 		return;
		// 	}
		// 	if (sugar % 5 == 0) {
		// 		result += (sugar / 5);
		// 		System.out.println(result);
		// 		return;
		// 	}
		// 	sugar -= 3;
		// 	result++;
		// }
		// System.out.println(result);
	}
}
