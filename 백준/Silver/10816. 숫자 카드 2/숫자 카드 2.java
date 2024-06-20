import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Map<Integer, Integer> myMap = new HashMap<>();
		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int key = Integer.parseInt(st.nextToken());
			myMap.put(key,myMap.getOrDefault(key,0)+1);
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (myMap.containsKey(num)) {
				sb.append(myMap.get(num) + " ");
			}else
				sb.append("0 ");
		}
		System.out.println(sb);
	}

}
