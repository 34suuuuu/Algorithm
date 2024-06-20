import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Map<String, Integer> people = new HashMap<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			people.put(name,people.getOrDefault(name,0)+1);
		}
		List<String> names = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			String name = br.readLine();
			if (people.containsKey(name))
				names.add(name);
		}
		Collections.sort(names);
		StringBuilder sb = new StringBuilder();
		sb.append(names.size()).append("\n");
		for(String name : names) {
			sb.append(name).append("\n");
		}

		System.out.println(sb);
	}
}
