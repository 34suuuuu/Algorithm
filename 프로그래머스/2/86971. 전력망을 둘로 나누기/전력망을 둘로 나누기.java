import java.util.*;

class Solution {
    static boolean[] visited;
    static int[][] maps;
    static int result = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
    
        maps = new int[n + 1][n + 1];
        for(int[] wire : wires){
            int w1 = wire[0];
            int w2 = wire[1];
            maps[w1][w2] = maps[w2][w1] = 1;
        }
       
        for(int i=0; i<wires.length; i++){
            dfs(i, n, wires);
        }
        
        return result;
    }
    
    private static void dfs(int idx, int n, int[][] wires){
        visited = new boolean[n + 1];

        // 전선 분할
        int w1 = wires[idx][0];
        int w2 = wires[idx][1];
        maps[w1][w2] = maps[w2][w1] = 0;
        
        int cnt = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(w1);
        
        while(!que.isEmpty()){
            int cur = que.poll();
            visited[cur] = true;
            
            for(int i=1; i<=n; i++){
                if(!visited[i] && maps[cur][i] == 1){
                    que.add(i);
                    cnt++;
                }
            }
        }
        result = Math.min(result, Math.abs(n - 2*cnt));
        
        // 전선 재연결
        maps[w1][w2] = maps[w2][w1] = 1;

    }
}