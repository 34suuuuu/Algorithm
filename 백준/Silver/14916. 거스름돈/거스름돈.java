import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int cnt = 0;

		while(true){
			if (n % 5 == 0) {
				cnt += (n / 5);
				System.out.println(cnt);
				break;
			} else {
				n -= 2;
				cnt++;
			}

			if (n < 0) {
				System.out.println(-1);
				break;
			}

		}
	}
}
