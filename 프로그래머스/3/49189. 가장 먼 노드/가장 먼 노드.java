import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		boolean[] visited = new boolean[n + 1];
		int[] dist = new int[n + 1];
		for (int[] i : edge) {
			adjList.get(i[0]).add(i[1]);
			adjList.get(i[1]).add(i[0]);
		}

		for (List<Integer> list : adjList) {
			Collections.sort(list);
		}

		int maxDist = Integer.MIN_VALUE;
		Queue<Integer> que = new LinkedList<>();
		que.add(1);
		while (!que.isEmpty()) {
			int cur = que.poll();

			for(int target : adjList.get(cur)) {
				if (!visited[target]) {
					visited[target] = true;
					dist[target] = dist[cur] + 1;
					que.add(target);
				}
				maxDist = Math.max(maxDist, dist[target]);
			}
		}
		for (int i = 0; i <= n; i++) {
			if (i != 1 && maxDist == dist[i]) {
				answer++;
			}
		}
        return answer;
    }
}