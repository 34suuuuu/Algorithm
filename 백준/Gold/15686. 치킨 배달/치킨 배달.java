import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] maps;
	static int n, m;
	static List<int[]> houses;
	static List<int[]> chickens;
	static boolean[] opened;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		maps = new int[n][n];
		houses = new ArrayList<>();
		chickens = new ArrayList<>();
		result = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());

				if(maps[i][j] == 1){	// 집
					houses.add(new int[]{i, j});
				} else if (maps[i][j] == 2) {	// 치킨집
					chickens.add(new int[]{i, j});
				}
			}
		}

		opened = new boolean[chickens.size()];

		dfs(0, 0);
		System.out.println(result);

	}

	private static void dfs(int depth, int idx) {
		if (depth == m) {
			int total_length = 0;

			// 조합별 치킨거리 구하기
			for (int i = 0; i < houses.size(); i++) {
				int chicken_length = Integer.MAX_VALUE;
				for (int j = 0; j < chickens.size(); j++) {
					if (opened[j]) {	// 치킨집을 열었다면
						int dist = Math.abs(houses.get(i)[0] - chickens.get(j)[0]) + Math.abs(houses.get(i)[1] - chickens.get(j)[1]);
						chicken_length = Math.min(chicken_length, dist);
					}
				}
				total_length += chicken_length;
			}
			result = Math.min(result, total_length);
			return;
		}


		// 가능한 조합 구하기
		for (int i = idx; i < chickens.size(); i++) {
			opened[i] = true;
			dfs(depth + 1, i + 1);
			opened[i] = false;
		}
	}

}
