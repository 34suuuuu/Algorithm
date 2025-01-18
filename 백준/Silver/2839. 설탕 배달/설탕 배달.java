import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int result = 0;
		while (n > 0) {
			if (n < 3) {
				System.out.println(-1);
				return;
			}
			if (n % 5 == 0) {
				result += (n / 5);
				System.out.println(result);
				return;
			}
			 n-= 3;
			result++;
		}
		System.out.println(result);
	}
}
