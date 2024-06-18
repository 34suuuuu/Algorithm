import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> numberList = new ArrayList<>();
	static int[] numbers = new int[9];
	static boolean[] visited = new boolean[9];

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 9; i++) {
			numbers[i] = i + 1;
		}
		numberList.add(0);
		for (int i = 1; i <= 9; i++) {
			makeNums(i, 0, visited, 0);
		}

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextInt()) {
			int n = scanner.nextInt();
			if (n >= 987654321) {
				System.out.println(0);
			} else {
				int start = 0;
				int end = numberList.size();
				while (start + 1 < end) {
					int mid = (start + end) / 2;
					if (numberList.get(mid) <= n) {
						start = mid;
					} else {
						end = mid;
					}
				}
				if (numberList.get(start) <= n) {
					System.out.println(numberList.get(end));
				}
			}
		}

		scanner.close();
	}

	static void makeNums(int mxlen, int cnt, boolean[] visited, int val) {
		if (cnt >= mxlen) {
			numberList.add(val);
		} else {
			for (int i = 0; i < 9; i++) {
				if (visited[i]) {
					continue;
				}
				visited[i] = true;
				makeNums(mxlen, cnt + 1, visited, val * 10 + numbers[i]);
				visited[i] = false;
			}
		}
	}
}
