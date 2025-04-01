import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public int solution(String dirs) {
        int answer = 0;
        int x = 5, y = 5;
        visited = new boolean[121][121];
        
        for(int i = 0; i < dirs.length(); i++){
            char cmd = dirs.charAt(i);
            int nx = 0, ny = 0;
            switch(cmd){
                case 'U':
                    nx = x + dx[0];
                    ny = y + dy[0];
                    break;
                case 'D':
                    nx = x + dx[1];
                    ny = y + dy[1];
                    break;
                case 'L':
                    nx = x + dx[2];
                    ny = y + dy[2];
                    break;
                case 'R':
                    nx = x + dx[3];
                    ny = y + dy[3];
                    break;
            }
            
            if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;

            // 방문 처리
            int start = x * 11 + y;
            int end   = nx * 11 + ny;
            if(!visited[start][end]){
                visited[start][end] = true;
                visited[end][start] = true;
                answer++;
            }
            x = nx;
            y = ny;     
        }
        
        return answer;
    }
}