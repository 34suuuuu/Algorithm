import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] splitNums = br.readLine().split("-");
		List<Integer> result = new ArrayList<>();

		for (String str : splitNums) {
			int sum = 0;
			String[] tmpString = str.split("\\+");	// +로 숫자 나눠서 더해주기
			for (String tmp : tmpString) {
				sum += Integer.parseInt(tmp);
			}
			result.add(sum);
		}
		long answer = result.get(0);
		for(int i=1; i<result.size(); i++) {
			answer -= result.get(i);
		}

		System.out.println(answer);
	}
}
