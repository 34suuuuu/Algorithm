import java.util.*;

class Solution {
    
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				bfs(i, computers);
				answer++;
			}
		}
                
        return answer;
    }
    
    static void bfs(int start, int[][] computers) {
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visited[start] =true;

		while (!que.isEmpty()) {
			int cur = que.poll();
			visited[cur] =true;

			for (int i = 0; i < computers.length; i++) {
				if (!visited[i] && computers[cur][i] == 1 && i != cur) {
					que.add(i);
				}
			}
		}
	}
}