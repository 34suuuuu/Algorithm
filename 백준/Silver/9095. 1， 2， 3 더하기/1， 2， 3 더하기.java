import java.util.*;

public class Main {
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        int dp[] = new int [11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int j = 4; j <= 10; j++) { // 4부터 반복
			dp[j] = dp[j-3] + dp[j-2] + dp[j-1]; // 점화식
		}
		
		for(int i=0;i<t;i++) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}	
	}
}