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
			int sum = Arrays.stream(str.split("\\+"))
				.mapToInt(Integer::parseInt)
				.sum();
			result.add(sum);
		}
		long answer = result.get(0) - IntStream.range(1, result.size())
			.map(result::get)
			.sum();

		System.out.println(answer);
	}
}
