import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] visited = new boolean[100][100];
		int[][] papers = new int[100][100];

		int n = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for (int x = a; x < a + 10; x++) {
				for (int y = b; y < b + 10; y++) {
					if (!visited[x][y]) {
						visited[x][y] = true;
						result++;
					}
				}
			}
		}

		System.out.println(result);
	}
}
