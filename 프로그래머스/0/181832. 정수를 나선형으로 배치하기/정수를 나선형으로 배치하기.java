class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int num = 1;
        int row = 0, col = 0, idx = 0;
        
        while(num <= n*n){
            answer[row][col] = num++;
            
            int nr = row + dr[idx % 4];
            int nc = col + dc[idx % 4];

            if (nr < 0 || n <= nr || nc < 0 || n <= nc || answer[nr][nc] != 0){
                idx += 1;
            }

            row = row + dr[idx % 4];
            col = col + dc[idx % 4];
        }
   
        return answer;
    }
}