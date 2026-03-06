import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int N = queries.length;
        int[] answer = new int[N];
        
        int[][] board = new int[rows][columns];
        int num = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j< columns; j++){
                board[i][j] = num++;
            }
        }
        
        for(int i = 0; i < N; i++){
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            
            int tmp = board[x1][y1];
            int min = Integer.MAX_VALUE;
            for(int x = x1; x < x2; x++){
                min = Math.min(min, board[x][y1]);
                board[x][y1] = board[x+1][y1];
            }
            
            for(int y = y1; y < y2; y++){
                min = Math.min(min, board[x2][y]);
                board[x2][y] = board[x2][y+1];
            }
            
            for(int x = x2; x > x1; x--){
                min = Math.min(min, board[x][y2]);
                board[x][y2] = board[x-1][y2];
            }
            
            for(int y = y2; y > y1; y--){
                min = Math.min(min, board[x1][y]);
                board[x1][y] = board[x1][y-1];
            }
            
            board[x1][y1+1] = tmp;
            
            answer[i] = min;
            
        }
        
        return answer;
    }
}