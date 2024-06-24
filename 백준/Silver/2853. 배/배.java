import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int boat = 0;
		for (int i = 1; i < n; i++) {
			if (arr[i] == 0) {
				continue;
			}
			int a = arr[i] - arr[0];
			int tmp = 1;
			for (int j = 1; j < n; j++) {
				if (arr[j] == 0) {
					continue;
				}
				if (arr[j] % a == 1) {
					tmp += a;
					arr[j] = 0;
				}
			}
			if (tmp != 1) {
				boat++;
			}
		}
		System.out.println(boat);
	}
}
