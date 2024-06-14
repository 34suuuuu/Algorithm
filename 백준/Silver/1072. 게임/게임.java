import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextInt();
		long y = sc.nextInt();
		long z = getZ(x, y);

		long answer = -1;
		long left = -1;
		long right = 1000000000;

		if (z >= 99) {
			System.out.println(answer);
			return;
		}
		while (left <= right) {
			long mid = (left + right) / 2;
			if (getZ(x + mid, y + mid) != z) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(answer);
	}

	static long getZ(long x, long y){
		return  100 * y / x;
	}
}
