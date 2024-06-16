import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer tk = null;

	static int N, T, S, Lsum, Rsum, Lmax, Rmax;
	static int[] L, R;
	
	public static void main(String[] args) throws Exception {
		tk = new StringTokenizer(rd.readLine());
		N = Integer.parseInt(tk.nextToken());
		T = Integer.parseInt(tk.nextToken());
		
		L = new int[N];
		R = new int[N];
		for (int i=0; i<N; i++) {
			tk = new StringTokenizer(rd.readLine());
			L[i] = Integer.parseInt(tk.nextToken());
			R[i] = Integer.parseInt(tk.nextToken());
			Lsum += L[i];
			Rsum += R[i];
			Lmax = Math.max(Lmax, L[i]);
			Rmax = Math.max(Rmax, R[i]);
		}
		
		if (T < Lsum || T > Rsum) {	// 모두 L만큼 먹어도 부족하거나 모두 R만큼 먹어도 남으면 안됨
			System.out.println(-1);
			return;
		}
		
		// S: Lmax~Rmax 이분탐색
		int lo = Lmax;
		int hi = Rmax;
		int S = -1;
		int sum;
		while (lo <= hi) {
			sum = 0;
			S = (lo + hi) / 2;
			for (int i=0; i<N; i++) {
				sum += Math.min(R[i], S);
			}
			if (sum >= T) hi = S - 1;
			else lo = S + 1;
		}
		
		System.out.println(S);
	}
}