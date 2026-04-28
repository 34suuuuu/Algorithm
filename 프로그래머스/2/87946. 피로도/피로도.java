import java.util.*;

class Solution {
    static boolean[] visited;
    static HashSet<Integer> nums = new HashSet<>();
    
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        visited = new boolean[dungeons.length];

        int cnt = 0;
        dfs(k, 0, cnt, dungeons);
        
        for(Integer num : nums){
            answer = Math.max(num, answer);
        }
        
        return answer;
    }
    
    private static void dfs(int k, int idx, int cnt, int[][] dungeons){
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k >= dungeons[i][0]){
                // 방문하지 않았고, 최소필요피로도보다 현재가 큰 상태
                visited[i] = true;
                nums.add(cnt + 1);
                dfs(k - dungeons[i][1], idx + 1, cnt + 1, dungeons);
                visited[i] = false;
            }
        }
    }
    
   
}