import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		Map<Integer, String> indexMap = new HashMap<>();
		Map<String, Integer> nameMap = new HashMap<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			indexMap.put(i + 1, name);
			nameMap.put(name, i + 1);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (str.charAt(0) < 65) {
				// 숫자라면
				sb.append(indexMap.get(Integer.parseInt(str))).append("\n");
			} else {
				// 문자라면
				sb.append(nameMap.get(str)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
