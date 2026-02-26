import java.util.*;

class Solution {
    static boolean[][] visited;    
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    int[] oil;
    int N, M;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        N = land.length;
        M = land[0].length;
        oil = new int[M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 1 && visited[i][j] == false) {
                    bfs(land, i, j);
                }
            }
        }

        
        
        answer = Arrays.stream(oil).max().getAsInt();
        return answer;
    }
    
    public void bfs(int[][] land, int x, int y){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y});
        visited[x][y] = true;

        int cnt = 1;
        Set<Integer> set = new HashSet<>();// 석유의 위치 저장
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            set.add(cur[1]);
            
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny] || land[nx][ny] == 0) continue;

                que.offer(new int[]{nx,ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }
        for(Integer i : set){
            oil[i] += cnt;
        }
    }
}