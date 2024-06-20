import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		Map<Integer, Integer> map = new HashMap<>();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++){
			int key = Integer.parseInt(st.nextToken());
			map.put(key, 1);
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			if(map.containsKey(Integer.parseInt(st.nextToken())))
				sb.append(1 + " ");
			else
				sb.append(0 + " ");
		}
		System.out.println(sb);
	}
}
