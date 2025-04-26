import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] maps;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		// 배열 초기화
		maps = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				maps[i][j] = str.charAt(j) - '0';
			}
		}

		int size = Math.min(n, m);
		while (size > 1) {
			for (int i = 0; i <= n - size; i++) {
				for (int j = 0; j <= m - size; j++) {
					if (chkValue(i, j, size)) {
						// 조건에 만족하는 정사각형을 찾았다면 -> 최대값
						System.out.println(size * size);
						return;
					}
				}
			}
			size--;
		}
		System.out.println(size * size);
	}

	private static boolean chkValue(int x, int y, int size) {
		if (x + size - 1 < n && y + size - 1 < m) {
			int v1 = maps[x][y];
			int v2 = maps[x + size - 1][y];
			int v3 = maps[x][y + size - 1];
			int v4 = maps[x + size - 1][y + size - 1];

			if (v1 == v2 && v1 == v3 && v1 == v4) {
				return true;
			}
		}
		return false;
	}
}
