import java.util.*;

class Solution {
    static boolean[] visited;
    static List<Integer> result;
    static Set<Integer> resultSet = new HashSet<>();
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        visited = new boolean[dungeons.length];
		int cnt = 0;
        
		dfs(k, 0, cnt, dungeons);
		answer = Integer.MIN_VALUE;
		for (int i : resultSet) {
			answer = Math.max(i, answer);
		}

        
        return answer;
    }
    
    static void dfs(int k, int start, int cnt, int[][] dungeons) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && k >= dungeons[i][0]) {
				visited[i] = true;
				resultSet.add(cnt + 1);
				dfs(k - dungeons[i][1], i + 1, cnt + 1, dungeons);
				visited[i] = false;
			}
		}

	}
}