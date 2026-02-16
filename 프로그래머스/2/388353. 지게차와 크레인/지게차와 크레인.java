import java.io.*;
import java.util.*;

class Solution {
    char[][] map;
    boolean[][] visited;
    int n, m, answer;
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};
    
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        
        answer = (n * m);

        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = storage[i].toCharArray();
        }
        
        for(String req : requests) {
            if(req.length() == 1) {
                useFork(req.charAt(0));
            }else{
                useCrane(req.charAt(0));
            }
        }
        
        return answer;
    }
    
    
    // 지게차: 접근 가능한 컨테이너만 제거
    public void useFork(char req){
        // bfs 로 탐색
        visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i][0]) dfs(i, 0, req);
            if(!visited[i][m-1]) dfs(i, m-1, req);
        }
        
        for(int i = 0; i < m; i++) {
            if(!visited[0][i]) dfs(0, i, req);
            if(!visited[n-1][i]) dfs(n-1, i, req);
        }
    }
    
    // 크레인 : 모든 컨테이너 제거
    public void useCrane(char req){
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == req) {
                    answer--;
                    map[i][j] = 0;
                }
            }
        }
    }
    
    // 접근 가능한 컨테이너인지 판단
    public void dfs(int x, int y, char req){
        visited[x][y] = true;
        
        if(map[x][y] == 0) {
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(!visited[nx][ny]) dfs(nx, ny, req);
            }
        }
        if(map[x][y] == req) {
            answer--;
            map[x][y] = 0;
        }
    }
    
}