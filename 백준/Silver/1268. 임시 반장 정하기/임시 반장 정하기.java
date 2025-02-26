import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		int[][] students = new int[n][5];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <  5; j++) {
				students[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int maxValue = 0;
		int leader = 0;
		for (int i = 0; i < n; i++) {
			Set<Integer> sameClass = new HashSet<>();
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < n; k++) {
					if(students[i][j] == students[k][j] && i != k) {
						sameClass.add(k);
					}
				}
			}
			if (sameClass.size() > maxValue) {
				leader = i;
				maxValue = sameClass.size();
			}
		}

		System.out.println(leader + 1);


	}
}
