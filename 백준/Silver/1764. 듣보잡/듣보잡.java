import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashSet<String> people = new HashSet<>();
		List<String> result = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			people.add(br.readLine());
		}
		for (int i = 0; i < m; i++) {
			String person = br.readLine();
			if (people.contains(person)) {
				result.add(person);
			}
		}
		Collections.sort(result);

		System.out.println(result.size());
		for (String s : result) {
			System.out.println(s);
		}
	}

}
