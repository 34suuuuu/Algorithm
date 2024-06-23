import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stringTokenizer.nextToken());
		int m = Integer.parseInt(stringTokenizer.nextToken());
		int cnt = 0;

		char[][] matrixA = new char[n][m];
		char[][] matrixB = new char[n][m];

		for(int i = 0 ; i < n ; i++){
			String str = br.readLine();
			matrixA[i] = str.toCharArray();
		}

		for(int i = 0 ; i < n ; i++){
			String str = br.readLine();
			matrixB[i] = str.toCharArray();
		}

		for(int i = 0 ; i <= n-3 ; i++){
			for(int j = 0; j <= m -3 ; j++){
				if(matrixA[i][j] != matrixB[i][j]) {
					swap(matrixA, i, j);
					cnt++;
				}
			}
		}

		for(int i = 0 ; i < n ; i++){
			for(int j = 0; j < m; j++){
				if(matrixA[i][j] != matrixB[i][j]){
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(Arrays.deepEquals(matrixA, matrixB) ? cnt : -1);
	}

	static void swap(char[][] arr, int x, int y) {
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				arr[i][j] = arr[i][j] == '1' ? '0' : '1';
			}
		}
	}
}
