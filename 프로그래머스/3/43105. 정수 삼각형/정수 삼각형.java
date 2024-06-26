import java.util.Arrays;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp = new int[triangle.length][];
		for(int i=0; i<triangle.length; i++) {
			dp[i] = new int[triangle[i].length];
		}
		dp[0][0] = triangle[0][0];

		// dp[1][0] = dp[0][0] + triangle[1][0];
		// dp[1][1] = dp[0][0] + triangle[1][1];
		//
		// dp[2][0] = triangle[1][0];
		// dp[2][1] = Math.max(dp[1][0] + triangle[2][1], triangle[1][1] + dp[2][1]);
		//
		// dp[3][1] = Math.max(triangle[2][0] + dp[3][1], triangle[2][1] + dp[3][1]);
		// dp[3][2] = Math.max(triangle[2][1] + dp[3][2], triangle[2][2] + dp[3][2]);

		answer = Integer.MIN_VALUE;
		for (int i = 1; i < triangle.length; i++) {
			for (int j = 0; j < triangle[i].length; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
				}  else if (j == triangle[i].length - 1) {
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
				}
			}

		}
		answer = Arrays.stream(dp[triangle.length - 1]).max().getAsInt();
        
        return answer;
    }
}