public class Main {
	public static void main(String[] args) {
		int[] nums = new int[10001];
		for (int i = 1; i <= 10000; i++) {
			int num = solution(i);
			nums[num] = -1;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10000; i++) {
			if(nums[i] != -1)
				sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	public static int solution(int n) {
		int sum = n;

		while (n != 0) {
			sum += (n % 10);
			n /= 10;
		}
		return (sum > 10000 ? 0 : sum);
	}
}
