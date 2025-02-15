import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] cnt = new int[9];

		for (int i=0; i<str.length(); i++) {
			int num = str.charAt(i) - '0';

			if (num == 9) num = 6;
			cnt[num]++;
		}
		cnt[6] = cnt[6] / 2 + cnt[6] % 2;

		Arrays.sort(cnt);
		System.out.println(cnt[8]);
	}
}