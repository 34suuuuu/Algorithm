import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();

		while (true) {
			int min = n / l - (l - 1) / 2;

			if (min < 0 || l > 100) {
				System.out.println(-1);
				return;
			}

			int sum = l * (min * 2 + (l - 1)) / 2;

			if (sum == n) {
				for (int i = 0; i < l; i++) {
					System.out.print((min + i) + " ");
				}
				return;
			}
			l++;
		}
	}
}
