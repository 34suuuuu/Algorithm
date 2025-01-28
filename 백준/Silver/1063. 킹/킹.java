import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[] king, rock;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		king = st.nextToken().toCharArray();
		rock = st.nextToken().toCharArray();
		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			String cmd = br.readLine();

		// 	움직였을 때, 돌과 같은 위치인지 확인
		// 	같은 위치가 아니라면 움직이고, 같은 위치라면 돌도 움직여줘야함
			char[] next = move(cmd, king);
			if(chkRange(next)) continue;

			if (next[0] == rock[0] && next[1] == rock[1]) {
				char[] next_rock = move(cmd, rock);
				if(chkRange(next_rock)) continue;
				rock = next_rock;
			}
			king = next;
		}

		System.out.println(String.valueOf(king[0]) + String.valueOf(king[1]));
		System.out.println(String.valueOf(rock[0]) + String.valueOf(rock[1]));
	}

	public static char[] move(String cmd, char[] cur) {
		char[] next = cur.clone();

		switch (cmd) {
			case "R":
				next[0]++;
				break;
			case "L":
				next[0]--;
				break;
			case "B":
				next[1]--;
				break;
			case "T":
				next[1]++;
				break;
			case "RT":
				next[0]++;
				next[1]++;
				break;
			case "LT":
				next[0]--;
				next[1]++;
				break;
			case "RB":
				next[0]++;
				next[1]--;
				break;
			case "LB":
				next[0]--;
				next[1]--;
				break;
		}
		return next;
	}

	public static boolean chkRange(char[] cur) {
		if (cur[0] < 'A' || cur[0] > 'H' || cur[1] < '1' || cur[1] > '8') return true;
		return false;
	}
}
