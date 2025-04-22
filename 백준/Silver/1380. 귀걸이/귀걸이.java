import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int idx = 0;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			idx++;
			if(n == 0) break;

			ArrayList<String> names = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				names.add(br.readLine());	// 여학생 이름
			}

			ArrayList<Integer> earingGirs = new ArrayList<>();
			for (int i = 0; i < n * 2 - 1; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());

				if(earingGirs.contains(num)){earingGirs.remove((Integer)num);}
				else earingGirs.add(num);
			}
			System.out.println(idx + " " + names.get(earingGirs.get(0) - 1));
		}
	}
}
