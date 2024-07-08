import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] houses = new int[n];
		for (int i = 0; i < n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);

		int start = 1;
		int end = houses[n - 1] - houses[0];
		while (start <= end) {
			int mid = (start + end) / 2;

			int position = 0;
			int cnt = 1;
			for (int i = 1; i < n; i++) {
				if (houses[i] - houses[position] >= mid) {
					// 최소거리보다 크다면 설치
					position = i;
					cnt++;
				}
			}
			if (cnt < c) {
				// 설치 갯수가 적다면 최소 거리를 줄여주기
				end = mid - 1;
				continue;
			}
			start = mid + 1;
		}
		System.out.println(start - 1);
	}
}
