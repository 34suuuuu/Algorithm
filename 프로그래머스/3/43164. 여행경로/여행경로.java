import java.util.*;

class Solution {
    static boolean[] visited;
	static ArrayList<String> resultList;
	static String[] answer;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
		int idx = 0;
		resultList = new ArrayList<>();

		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if (o2[0].compareTo(o1[0]) == 0) {
					return o1[1].compareTo(o2[1]);
				}
				return o1[0].compareTo(o2[0]);
			}
		});

		dfs(tickets,"ICN", "ICN ", idx);

		answer = resultList.get(0).split(" ");
        
        return answer;
    }
    
    
	static void dfs(String[][] tickets, String start, String result, int idx) {
		if (idx == tickets.length) {
			resultList.add(result);
			return;
		}
		for (int i = 0; i < tickets.length; i++) {
			if (start.equals(tickets[i][0]) && !visited[i])  {
				visited[i] = true;
				result +=  (tickets[i][1]+" ");
				dfs(tickets, tickets[i][1], result, idx + 1);
				result = result.substring(0, result.length()-4);
				visited[i] = false;
			}
		}

	}
}