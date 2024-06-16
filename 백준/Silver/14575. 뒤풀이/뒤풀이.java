import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		int[] L = new int[N];
		int[] R = new int[N];
		int Lsum = 0, Rsum = 0, Lmax = 0, Rmax = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			L[i] = Integer.parseInt(st.nextToken());
			R[i] = Integer.parseInt(st.nextToken());
			Lsum += L[i];
			Rsum += R[i];
			Lmax = Math.max(Lmax, L[i]);
			Rmax = Math.max(Rmax, R[i]);
		}
		if (T < Lsum || Rsum < T) {
			System.out.println(-1);
			return;
		}

		int left = Lmax;
		int right = Rmax;
		int S = -1;
		while (left <= right) {
            		int sum = 0;
			S = (left + right) / 2;

			for (int i = 0; i < N; i++) {
				sum += Math.min(R[i], S);
			}
			if (sum >= T) {
				right = S - 1;
			} else {
				left = S + 1;
			}
		}
		System.out.println(S);
	}
}
