import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Set<Integer> A = new HashSet<>();
		Set<Integer> B = new HashSet<>();
		Set<Integer> tmp = new HashSet<>();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			A.add(num);
			tmp.add(num);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			B.add(num);
		}
		A.removeAll(B);
		B.removeAll(tmp);

		System.out.println(A.size() + B.size());
	}
}
