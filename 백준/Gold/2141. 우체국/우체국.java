import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long sum = 0;
		List<Town> towns = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long pos = Integer.parseInt(st.nextToken());
			long num = Integer.parseInt(st.nextToken());
			sum += num;
			towns.add(new Town(pos, num));
		}

		long result = 0;
		Collections.sort(towns);
		for (int i = 0; i < n; i++) {
			result += towns.get(i).nums;
			long mid = (sum + 1) / 2;
			if (mid <= result) {
				System.out.println(towns.get(i).pos);
				return;
			}
		}
	}
}

class Town implements Comparable<Town> {
	long pos;
	long nums;

	Town(long pos, long nums) {
		this.pos = pos;
		this.nums = nums;
	}

	@Override
	public int compareTo(Town o) {
		return (int)(this.pos - o.pos);
	}

}