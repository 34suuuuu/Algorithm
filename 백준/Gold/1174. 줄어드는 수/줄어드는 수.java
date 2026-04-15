import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static ArrayList<Long> nums = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n < 10) {
			System.out.println(n - 1);
			return;
		}else if(n > 1023){
			System.out.println(-1);
			return;
		}

		for (int i = 0; i < 10; i++) {
			search(1, i);
		}
		Collections.sort(nums);
		System.out.println(nums.get(n - 1));
	}

	private static void search(int idx, long num) {
		if(idx > 10) return;

		nums.add(num);
		for (int i = 0; i < num % 10; i++) {
			search(idx+1, num * 10 + i );
		}
	}
}
