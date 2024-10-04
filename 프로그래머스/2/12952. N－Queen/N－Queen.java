class Solution {
    static int[] board;
    static int answer = 0;
    
    public int solution(int n) {
        
        board = new int[n];
        backTracking(0,n);
        
        return answer;
    }
    public void backTracking(int cnt, int n){
        if(cnt == n){
            answer++;
            return;
        }
        
        for(int i=0; i<n; i++){
                board[cnt] = i;
            
            if(checkPos(cnt)){
//                 둘 수 있다면
                backTracking(cnt+1, n);
            }
        }
    }
    public boolean checkPos(int col){
        for(int i=0; i<col; i++){
            if(board[col] == board[i]){
                return false;
            }else if(Math.abs(col-i) == Math.abs(board[col] - board[i])) return false;
        }
        return true;
    }
}