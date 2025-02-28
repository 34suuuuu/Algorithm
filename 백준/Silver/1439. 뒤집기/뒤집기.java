import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("");
		int zero = 0;
		int non = 0;

		String pre = input[0];
		for (int i = 1; i < input.length; i++) {
			String cur = input[i];
			if (!pre.equals(cur)) {
				pre = cur;
				if(cur.equals("0")) non++;
				else zero++;
			}
		}
		if(pre.equals("1")) non++;
		else zero++;
		System.out.println(Math.min(non, zero));

	}
}
