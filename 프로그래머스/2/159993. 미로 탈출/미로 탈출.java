import java.util.*;
class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[] start, lever, end;
    static boolean[][] visited;
    static char[][] map;
    static int N, M;
    
    public int solution(String[] maps) {
        int answer = -1;
        
        N = maps.length;
        M = maps[0].length();
               
        map = new char[N][M];        
        for (int i = 0; i < N; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'S') {
                    start = new int[]{i, j, 0};
                } else if (map[i][j] == 'E') {
                    end = new int[]{i, j, 0};
                } else if (map[i][j] == 'L') {
                    lever = new int[]{i, j, 0};
                }
            }
        }
        
        int res1 = bfs(start, lever);        
        int res2 = bfs(lever, end);        
        if(res1 == -1 || res2 == -1){
            return -1;
        }
        
        return res1 + res2;
    }
    
    public int bfs(int[] start, int[] end){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        visited = new boolean[N][M];
        visited[start[0]][start[1]] = true;
        que.add(start);
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            if(cur[0] == end[0] && cur[1] == end[1]) {
                return cur[2];
            }
            
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];    
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny] || map[nx][ny] == 'X') continue;
                
                visited[nx][ny] = true;
                que.add(new int[]{nx, ny, cur[2] + 1});
            }
        }
        return -1;
        
    }
}