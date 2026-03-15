import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		int[] scores = new int[n];
		if(n > 0){
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++){
				scores[i] = Integer.parseInt(st.nextToken());
			}
		}

		if(n == p && scores[n-1] >= score){
			System.out.println(-1);
			return;
		}
		else{
			int rank = 1;
			for(int i = 0; i < n; i++){
				if(scores[i] > score){
					rank++;
				}else break;
			}
			System.out.println(rank);
		}
	}
}
