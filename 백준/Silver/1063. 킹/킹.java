import java.io.*;
import java.util.*;

public class Main {
	static char[] king, rock;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		king = st.nextToken().toCharArray();
		rock = st.nextToken().toCharArray();
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			String command = br.readLine();
			char[] nKing = move(command, king);
			
			if(isOverRange(nKing)) continue;
			if(nKing[0] == rock[0] && nKing[1] == rock[1]) {
				char[] nRock = move(command, rock);
				if(isOverRange(nRock)) continue;
				rock = nRock;
			}
			king = nKing;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(king[0]) + String.valueOf(king[1]) + "\n");
		sb.append(String.valueOf(rock[0]) + String.valueOf(rock[1]) + "\n");
		System.out.println(sb);

	}

	static char[] move(String cmd, char[] target) {
		char[] result = target.clone();
		switch(cmd){
			case "R":
				result[0]++;
				break;
			case "L":
				result[0]--;
				break;
			case "B":
				result[1]--;
				break;
			case "T":
				result[1]++;
				break;
			case "RT":
				result[0]++;
				result[1]++;
				break;
			case "LT":
				result[0]--;
				result[1]++;
				break;
			case "RB":
				result[0]++;
				result[1]--;
				break;
			case "LB":
				result[0]--;
				result[1]--;
		}
		return result;
	}

	static boolean isOverRange(char[] cur) {
		if(cur[0] < 'A' || cur[0] > 'H' || cur[1] <= '0' || cur[1] > '8' ) return true;
		return false;
	}
}