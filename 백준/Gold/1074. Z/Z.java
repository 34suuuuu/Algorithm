import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N  = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int size = (int) Math.pow(2, N); // 한변의 길이

		solve(size, r, c);
		System.out.println(cnt);

	}

	public static void solve(int size, int x, int y){
		if(size == 1) return;

		if (x < size / 2 && y < size / 2) { // 왼쪽 위
			solve(size / 2, x, y);
		} else if (x < size / 2 && y >= size / 2) {	// 오른쪽 위
			cnt += (size * size / 4);
			solve(size / 2, x, y - size / 2);
		} else if (x >= size / 2 && y < size / 2) {	// 왼쪽 아래
			cnt += (size * size / 4) * 2;
			solve(size / 2, x - size / 2, y);
		} else if (x >= size / 2 && y >= size / 2) {	// 오른쪽 아래
			cnt += (size * size / 4) * 3;
			solve(size / 2, x - size / 2, y - size / 2);
		}
	}
}
