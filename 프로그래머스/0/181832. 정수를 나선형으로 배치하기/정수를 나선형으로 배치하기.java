class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int idx = 1;
        int row = 0;
        int col = 0;
        int rowEnd = n-1;
        int colEnd = n-1;
        
        int rowRange = n;
        int colRange = n;
        
        while(idx <= n*n){
            for(int i=0; i<rowRange; i++){
                if(answer[row][i] == 0){
                    answer[row][i] = idx++;
                }
            }
            for(int i=0; i<colRange; i++){
                if(answer[i][colEnd] == 0){
                    answer[i][colEnd] = idx++; 
                }
            }
            for(int i=rowRange-1; i>=0; i--){
                if(answer[rowEnd][i] == 0){
                    answer[rowEnd][i] = idx++;
                }
            }
            for(int i=colRange-1; i>=0; i--){
                if(answer[i][col] == 0){
                    answer[i][col] = idx++; 
                }
            }
            row++;
            col++;       
            rowEnd--;
            colEnd--;
        }
        
        return answer;
    }
}