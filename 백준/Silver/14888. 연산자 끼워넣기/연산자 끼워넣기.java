import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static int[] operators;
	static int n;
	static int maxValue = Integer.MIN_VALUE;
	static int minValue = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		nums = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		operators = new int[4];    // 연산자 갯수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		caclulate(nums[0], 1);
		System.out.println(maxValue);
		System.out.println(minValue);
	}

	// (계산 결과)
	public static void caclulate(int num, int idx) {
		if (idx == n) {
			maxValue = Math.max(maxValue, num);
			minValue = Math.min(minValue, num);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] > 0) {
				operators[i]--;

				if (i == 0) {
					caclulate(num + nums[idx], idx + 1);
				} else if (i == 1) {
					caclulate(num - nums[idx], idx + 1);
				} else if (i == 2) {
					caclulate(num * nums[idx], idx + 1);
				} else if (i == 3) {
					caclulate(num / nums[idx], idx + 1);
				}

				operators[i]++;
			}
		}


	}
}
