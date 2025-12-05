import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		while(t --> 0){
			int res = 0;
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			res = apt(k, n);
			sb.append(res).append("\n");
		}
		System.out.println(sb);

	}

	private static int apt(int k, int n){
		if(n == 0) return 0;
		else if(k == 0) return n;
		else return apt(k, n-1) + apt(k-1, n);
	}
}
